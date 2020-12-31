package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DAO_User_Master;
import service.DAO_Invoice_Service;
import service.Invoice_Master_DTO;
import service.Invoice_Transaction_DTO;
import service.Item_Master_DTO;
import service.User_Master_DTO;

@Controller
@Component
@RequestMapping("/pdf")
public class Generate_PDF {
	
	@Autowired
	DAO_Invoice_Service invdao;
	
	@Autowired
	DAO_User_Master udao;
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView getMethod(ModelAndView mandv, HttpServletRequest request) throws FileNotFoundException, DocumentException
//	{
//		mandv.setViewName("PDF");
//		return mandv;
//		
//	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView postMethod(ModelAndView mandv, HttpServletRequest request,HttpServletResponse response,ModelMap model) throws DocumentException, FileNotFoundException
	{
		System.out.println("pdf post code is executing...");
		HttpSession session = request.getSession();
		
		int userid = (int) session.getAttribute("userid");
		System.out.println("The PDF for the User id "+userid);
		List<Invoice_Master_DTO> masterdto = invdao.gett_all_invoice_single_user(userid);
		Iterator<Invoice_Master_DTO> iter1 = masterdto.iterator();
		int max = 0;
		while(iter1.hasNext())
		{	int temp = iter1.next().getInvno();
			if(max <= temp)
				max = temp;
		}
		System.out.println("the invoice number = "+max);
		
		Invoice_Master_DTO invdto1 = invdao.get_inv_by_invno(max);
		
		
		
		List<Invoice_Transaction_DTO> transdto = invdto1.getInv_trans();
		Iterator<Invoice_Transaction_DTO> iter = transdto.iterator();
//		while(iter.hasNext())
//		{
//			Invoice_Transaction_DTO invdto = iter.next();
//			float quantity = invdto.getQty();
//			Item_Master_DTO item = invdto.getItemdto();
//			float prize = item.getPrize();
//			System.out.print("   Item Name = "+item.getItemdesc());
//			System.out.print("   Item No = "+item.getItemno());
//			System.out.print("   Price = "+prize);
//			System.out.print("   Unit = "+item.getUnit());
//			System.out.print("   Item Category = "+item.getCategories());
//			System.out.print("   Quantiy = "+quantity);
//			System.out.println("    Total = "+(quantity*prize));
//		}
		Document doc = new Document();
		String path = request.getRealPath("/");
		File Report = new File(path+"Report.pdf");
		PdfWriter.getInstance(doc, new FileOutputStream(path+"Billing_PDF.pdf"));	
		doc.open();
		
		int uid = (int) session.getAttribute("userid");
		User_Master_DTO user = udao.get_user_by_uid(uid);
		
		
		
		Paragraph para = new Paragraph("           User Name = "+user.getUsername());
		Paragraph para1 = new Paragraph("     ");
		doc.add(para);
		doc.add(para1);
		
		
		PdfPTable table = new PdfPTable(5);
		
		
		
//		PdfPCell c1 = new PdfPCell(new Paragraph("SI No"));
		PdfPCell c2 = new PdfPCell(new Paragraph("Item Name"));
		PdfPCell c3 = new PdfPCell(new Paragraph("Price"));
		PdfPCell c4 = new PdfPCell(new Paragraph("Quantity"));
		PdfPCell c5 = new PdfPCell(new Paragraph("Unit"));
		PdfPCell c6 = new PdfPCell(new Paragraph("Total"));
		
//		table.addCell(c1);
		table.addCell(c2 );
		table.addCell(c3);
		table.addCell(c4);
		table.addCell(c5);
		table.addCell(c6);
		
		Float total = 0f;
		while(iter.hasNext())
		{
			Invoice_Transaction_DTO invdto = iter.next();
			float quantity = invdto.getQty();
			Item_Master_DTO item = invdto.getItemdto();
			float prize = item.getPrize();
			c2 = new PdfPCell(new Paragraph(item.getItemdesc()));
			String prizze = String.valueOf(prize);
			c3 = new PdfPCell(new Paragraph(prizze));
			String qqty = String.valueOf(quantity);
			c4 = new PdfPCell(new Paragraph(qqty));
			c5 = new PdfPCell(new Paragraph(item.getUnit()));
			String tot = String.valueOf(prize*quantity);
			total = total+(prize*quantity);
			c6 = new PdfPCell(new Paragraph((tot)));
			
			//table.addCell(c1);
			table.addCell(c2 );
			table.addCell(c3);
			table.addCell(c4);
			table.addCell(c5);
			table.addCell(c6);
			
		}
		
		c2 = new PdfPCell(new Paragraph(" "));
		c3 = new PdfPCell(new Paragraph("  "));
		c4 = new PdfPCell(new Paragraph("  "));
		c5 = new PdfPCell(new Paragraph("Total"));
		String stotal = String.valueOf(total);
		c6 = new PdfPCell(new Paragraph(stotal));
		
		table.addCell(c2 );
		table.addCell(c3);
		table.addCell(c4);
		table.addCell(c5);
		table.addCell(c6);
		doc.add(table);
		
	
		doc.close();
		String pdfName = path+"Billing_PDF.pdf";
		File pdf = new File(pdfName);
		response.setContentType("APPLICATION/OCTET-STREAM");
		try {
	        PrintWriter out = response.getWriter();
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + pdf.getName() + "\"");
	        FileInputStream f = new FileInputStream(pdf);
	        int i;
	        while ((i = f.read()) != -1) {
	            out.write(i);
	        }
	        f.close();
	        out.close();
	       
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Pdf created...");
		mandv.setViewName("User");
		return mandv;
		
		
	}
	
}
