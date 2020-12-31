package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Invoice_Service;
import service.Invoice_Master_DTO;

@Controller
@RequestMapping("/invoice_between_dates")
public class Select_dates {
	
	@Autowired
	DAO_Invoice_Service masterdao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv,HttpServletRequest request) throws ParseException
	{
		System.out.println("Get method of select dates is executing");
		mandv.setViewName("Select_Dates");
		
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv,HttpServletRequest request) throws ParseException
	{
		System.out.println("Post method of select dates is executing");
//		String date1 =  request.getParameter("from");
//		String date2 =  request.getParameter("to");
//		Date from=(Date) new SimpleDateFormat("yyyy-mm-dd").parse(date1);  
//		Date to=(Date) new SimpleDateFormat("yyyy-mm-dd").parse(date2);
		Date from = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("from"));
		Date to = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("to"));
		System.out.println(from+" : "+to);
		//System.out.println(date1+" : "+date2);
		List<Invoice_Master_DTO> masterdto =  masterdao.get_invoice_between_dates(from, to);
		HttpSession session = request.getSession();
		session.setAttribute("dateobj", masterdto);
		System.out.println("Size = "+masterdto.size());
		mandv.addObject("records",masterdto.size() );
		mandv.addObject("invoices",masterdto);
		mandv.setViewName("Invoice_between_dates");
		return mandv;
		
		
	}


}
