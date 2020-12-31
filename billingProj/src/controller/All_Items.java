package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Item_Master_Service;
import service.Item_Master_DTO;

@Controller
@RequestMapping("/all_item")
public class All_Items {
	
	@Autowired
	DAO_Item_Master_Service idao;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv, ModelMap model)
	{
		System.out.println("All item Get java code is executing...");
		List<Item_Master_DTO> item = idao.all_items();
//		for(Item_Master_DTO idto : item)
//			System.out.println("Name = "+idto.getItemdesc()+ " : "+"Price = "+idto.getPrize());
		//mandv.addObject("hello", "hello");
		//model.addAttribute("itemss",item);
		//request.setAttribute("itemss", item);
		
		mandv.addObject("itemss", item);
		mandv.setViewName("All_Items");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv)
	{
		System.out.println("All item Post java code is executing...");
		return mandv;
		
	}

}
