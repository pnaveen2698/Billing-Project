package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_User_Master_Service;
import service.User_Master_DTO;

@Controller
@RequestMapping({"/login"})
public class Login {
	
	@Autowired
	DAO_User_Master_Service udao;
	
	@Autowired
	User_Master_DTO udto;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv)
	{
		System.out.println("Login get java code executing...");
		String info = "(Please enter your User Name and Password)";
		mandv.addObject("info",info);
		mandv.setViewName("Login");
		return mandv;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv, HttpServletRequest request, HttpServletResponse response)
	{
	
		System.out.println("Login post java code executing...");
		  
			HttpSession session = request.getSession();
			
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			udto = udao.get_user_by_name(uname);
			
			
		
		
		System.out.println("User Name = "+uname+ "     "+"Password = "+upass);
	
		String check = udao.check_user(uname, upass);
		
		
		if(check.equals("success.user"))
		{
			int userid = udto.getUserid();
			session.setAttribute("userid", userid);
			session.setAttribute("uname", uname);
			if(udao.check_flag(uname) == 0)
			{
				
				System.out.println("Success as user!!!");
				udao.update_flag(uname, 1);
				mandv.setViewName("User");
				return mandv;
			}
			else
			{
				System.out.println("Already Login...");
				udao.update_flag(uname, 0);
				String info = "Already Login...";
				mandv.addObject("info",info);
				mandv.setViewName("Logout");
				return mandv;
			}
		}
		else if(check.equals("success.admin"))
		{
			
			if(udao.check_flag(uname) == 0)
			{
				int userid = udto.getUserid();
				session.setAttribute("userid", userid);
				session.setAttribute("uname", uname);
				System.out.println("Success as Admin!!!");
				udao.update_flag(uname, 1);
				mandv.setViewName("Admin");
				return mandv;
			}
			else
			{
				System.out.println("Already Login...");
				udao.update_flag(uname, 0);
				String info = "Already Login...";
				mandv.addObject("info",info);
				mandv.setViewName("Logout");
				return mandv;
			}
		}
		else if(check.equals("invalid"))
		{
			System.out.println("Invalid!!!");
			String info = "Invalid Username and Password...";
			mandv.addObject("info",info);
			mandv.setViewName("Login");
		}
		else if(check.equals("new"))
		{
			System.out.println("New!!!");
			String info = "You are a new user. Kindly Register now...";
			mandv.addObject("info",info);
			mandv.setViewName("Login");
		}
		
//		mandv.addObject("uname",uname);
//		mandv.setViewName("Welcome");
		return mandv;
	}
	
}
