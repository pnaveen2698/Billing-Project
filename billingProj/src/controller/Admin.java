package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_User_Master_Service;

@Controller
@RequestMapping("/admin")
public class Admin {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv)
	{
		mandv.setViewName("Admin");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		return mandv;
		
	}

}
