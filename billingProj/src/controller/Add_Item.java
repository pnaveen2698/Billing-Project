package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.DAO_Item_Master;
import service.DAO_Item_Master_Service;

@Controller
@RequestMapping("/add_item")
public class Add_Item {
	
	@Autowired
	DAO_Item_Master_Service idao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv)
	{
		System.out.println("Add item get java code executing...");
		mandv.setViewName("Add_Items");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv,HttpServletRequest request)
	{
		
		System.out.println("Add item post java code executing...");
		String itemdesc = request.getParameter("itemdesc");
		String category = request.getParameter("category");
		String unit = request.getParameter("unit");
		String image = request.getParameter("image");
		float price = Float.parseFloat(request.getParameter("price"));
		System.out.println(itemdesc+" : "+category+" : "+unit+" : "+price);
		idao.add_item(itemdesc, unit, category, price, image);
		mandv.setViewName("Admin");
		return mandv;
		
	}
	

}
