package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import service.DAO_User_Master_Service;
import service.User_Master_DTO;

@Controller
@RequestMapping("/logout")
public class Logout {

	@Autowired
	DAO_User_Master_Service udao;
	
	@Autowired
	Login log;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		System.out.println("Logout get code is Executing");
		
		String uname = (String) session.getAttribute("uname");
		String info = "(Please enter your User Name and Password)";
		mandv.addObject("info",info);
		
		udao.update_flag(uname, 0);
	
		mandv.setViewName("Login");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		return mandv;
		
	}
}
