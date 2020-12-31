package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Invoice_Service;
import service.Invoice_Master_DTO;
import service.User_Master_DTO;

@Controller


public class Generate_XLSX {

	@Autowired
	DAO_Invoice_Service masterdao;
	
	@RequestMapping(name = "/xlsx", method = RequestMethod.GET)
	public void postMethod(ModelAndView mandv,HttpServletRequest request,ModelMap model,HttpServletResponse response) throws Exception
	{
//		String pattern = "yyyy-MM-dd HH:MM:SS";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//	
		List<Invoice_Master_DTO> invoices = masterdao.get_total_invoice();

		if(invoices.size() > 0)
		{
			String path = request.getRealPath("/");
			File CustomerReport = new File(path+"CustomerReport.xls");
			try {
				HSSFWorkbook workbook = new HSSFWorkbook();   
				HSSFSheet sheet = workbook.createSheet("CustomerReport");   
				HSSFRow rowhead = sheet.createRow((short)0);  
				rowhead.createCell(0).setCellValue("Invoice Number"); 
				
				rowhead.createCell(2).setCellValue("Invoice Date");  
				rowhead.createCell(1).setCellValue("Invoice Amount");  
				for(int i=0;i<invoices.size();i++) {
				    rowhead = sheet.createRow((short)(i+1)); 
						rowhead.createCell(0).setCellValue(invoices.get(i).getInvno()); 
//						String date = simpleDateFormat.format(invoices.get(i).getDate());
//						System.out.println(date);
						rowhead.createCell(2).setCellValue(invoices.get(i).getDate().toString()); 
						rowhead.createCell(1).setCellValue(invoices.get(i).getTotal()); 
				}
				FileOutputStream fileOut = new FileOutputStream(path+"CustomerReport.xls");   
				workbook.write(fileOut); 
//				workbook.close();
				fileOut.close(); 
				response.setContentType("APPLICATION/OCTET-STREAM");
				try {
			        PrintWriter out = response.getWriter();
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + CustomerReport.getName() + "\"");
			        FileInputStream fl = new FileInputStream(CustomerReport);
			        int i;
			        while ((i = fl.read()) != -1) {
			            out.write(i);
			        }
			        fl.close();
			        out.close();
			        CustomerReport.delete();
			        
				}catch(Exception e) {e.printStackTrace();}
			}catch(Exception e) {e.printStackTrace();}
		}
		else
		{
			model.addAttribute("error", new String("No Invoice Found !"));
		}
			System.out.println("Excel generated...");
			        

	
}
	@RequestMapping(name = "/xlsx1", method = RequestMethod.POST)
	public void between_dates(ModelAndView mandv, HttpServletRequest request, HttpServletResponse response,ModelMap model)
	{
		HttpSession session = request.getSession();
		System.out.println("between dates post method is executing");
		List<Invoice_Master_DTO> invoices = (List<Invoice_Master_DTO>) session.getAttribute("dateobj");
		Iterator<Invoice_Master_DTO> it = invoices.iterator();
				while(it.hasNext())
				{
					System.out.println("Date = "+it.next().getDate());
				}
//		String pattern = "yyyy-MM-dd HH:MM:SS";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		
		if(invoices.size() > 0)
		{
			String path = request.getRealPath("/");
			File Report = new File(path+"Report.xls");
			try {
				HSSFWorkbook workbook = new HSSFWorkbook();   
				HSSFSheet sheet = workbook.createSheet("Report");   
				HSSFRow rowhead = sheet.createRow((short)0);  
				rowhead.createCell(2).setCellValue("Invoice Number");  
				rowhead.createCell(4).setCellValue("Invoice Date");  
				rowhead.createCell(3).setCellValue("Invoice Amount");
				rowhead.createCell(0).setCellValue("User Id");
				rowhead.createCell(1).setCellValue("User Name");
				for(int i=0;i<invoices.size();i++) {
				    rowhead = sheet.createRow((short)(i+1)); 
						rowhead.createCell(2).setCellValue(invoices.get(i).getInvno()); 
//						String date = simpleDateFormat.format(invoices.get(i).getDate().toString());
//						System.out.println(date);
						rowhead.createCell(4).setCellValue(invoices.get(i).getDate().toString()); 
						rowhead.createCell(3).setCellValue(invoices.get(i).getTotal());
						User_Master_DTO user = invoices.get(i).getUser();
						rowhead.createCell(0).setCellValue(user.getUserid());
						rowhead.createCell(1).setCellValue(user.getUsername());
				}
				FileOutputStream fileOut = new FileOutputStream(path+"Report.xls");   
				workbook.write(fileOut); 
				//workbook.close();
				fileOut.close(); 
				response.setContentType("APPLICATION/OCTET-STREAM");
				try {
			        PrintWriter out = response.getWriter();
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + Report.getName() + "\"");
			        FileInputStream fl = new FileInputStream(Report);
			        int i;
			        while ((i = fl.read()) != -1) {
			            out.write(i);
			        }
			        fl.close();
			        out.close();
			        Report.delete();
				}catch(Exception e) {e.printStackTrace();}
			}catch(Exception e) {e.printStackTrace();}
		}
		else
		{
			model.addAttribute("error", new String("No Invoice Found !"));
		}

	}
}
