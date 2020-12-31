package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Invoice_Service;
import service.Invoice_Master_DTO;
import service.User_Master_DTO;


@Controller
@RequestMapping("/user_invoices")
public class All_invoice_user {

	@Autowired
	DAO_Invoice_Service invdao;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv, HttpServletRequest request)
	{
		System.out.println("Get method of all user invoice is executing...");
		HttpSession  session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		System.out.println("User id  "+userid);
		List<Invoice_Master_DTO> masterdto = invdao.gett_all_invoice_single_user(userid);
//		Iterator<Invoice_Master_DTO> iter = masterdto.iterator();
//		while(iter.hasNext())
//		{
//			Invoice_Master_DTO master = iter.next();
//			User_Master_DTO user = master.getUser();
//			System.out.print("     User ID = "+user.getUserid());
//			System.out.print("     Invoice Number = "+master.getInvno());
//			System.out.println("     Total  ="+master.getTotal());
//		}
		String username = (String) session.getAttribute("uname");
		mandv.addObject("username", username);
		mandv.addObject("userid", userid);
	
		mandv.addObject("masterdto",masterdto);
		mandv.setViewName("All_invoice_user");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		System.out.println("Post method of all user invoice is executing...");

		return mandv;
		
	}

}
