package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Invoice_Service;
import service.DAO_User_Master_Service;
import service.Invoice_Master_DTO;

@Controller
@RequestMapping("/all_invoice")
public class All_Invoice {

	@Autowired
	DAO_Invoice_Service masterdao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv)
	{
		System.out.println("All Invoice get java code executing...");
		List<Invoice_Master_DTO> masterdto = masterdao.get_total_invoice();
		int size = masterdto.size();
		mandv.addObject("record", size);
		mandv.addObject("master", masterdto);
		mandv.setViewName("All_Invoice");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		System.out.println("All Invoice post java code executing...");
		return mandv;
		
	}
}
