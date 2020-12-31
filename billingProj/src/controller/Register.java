 package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_User_Master_Service;

@Controller
 @RequestMapping({"/register"})
public class Register {
	
	@Autowired
	DAO_User_Master_Service udao;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv)
	{
		System.out.println("Register get java code executing...");
		mandv.setViewName("Register");
		return mandv;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv,HttpServletRequest request)
	{
		System.out.println("Register post java code executing...");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		System.out.println(uname+" : "+upass+" : "+address+" : "+role);
		udao.register_user(uname, upass, role, address);
		String info = "(Thank you for Registering... Please enter your User Name and Password)";
		mandv.addObject("info",info);
		mandv.setViewName("Login");
		return mandv;
	}

}
