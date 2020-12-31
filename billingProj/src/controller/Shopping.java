package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.DAO_Invoice_Service;
import service.DAO_Item_Master_Service;
import service.Invoice_Transaction_DTO;
import service.Item_Master_DTO;

@Controller
@RequestMapping("/shopping")
public class Shopping {

	@Autowired
	DAO_Item_Master_Service idao;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMethod(ModelAndView mandv, HttpServletRequest request, HttpSession session)
	{
		List<Item_Master_DTO> idto = idao.all_items();
		Iterator<Item_Master_DTO> iter = idto.iterator();
		session = request.getSession();
		session.setAttribute("itemss", idto);
		while(iter.hasNext())
		{
			Item_Master_DTO idto1 = iter.next();
			System.out.println(idto1.getItemdesc()+" : "+idto1.getPrize()+" : "+idto1.getCategories());
		}
		String info = "Click Buy to make purchase";
		mandv.addObject("info",info);
		mandv.addObject("shopping", idto);
		mandv.setViewName("Shopping");
		return mandv;
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postMethod(ModelAndView mandv,HttpServletRequest request)
	{
//		HttpSession session = request.getSession();
//		
//		List<Item_Master_DTO> items =idao.all_items();
//		int len = items.size();
//
//		int[][] cart = new int[len][2];
//		for(int i=0;i<len;i++)
//		{
//			cart[i][0] = i+1;
//			cart[i][1] = Integer.parseInt(request.getParameter(String.valueOf(i+1)));
//		}
//		
//		for(int i=0; i<len; i++)
//		{
//			System.out.println(cart[i][0]+"    "+ cart[i][1] );
//			
//		}
//		session.setAttribute("cart", cart);
//		mandv.setViewName("all_invoice");
		return mandv;
		
	}
}
