package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class User {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv, HttpServletRequest request)
	{
		
		mandv.setViewName("User");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		return mandv;
		
	}

}
