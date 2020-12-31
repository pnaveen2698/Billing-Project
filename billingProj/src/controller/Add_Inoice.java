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
import service.Invoice_Master_DTO;
import service.Invoice_Transaction_DTO;
import service.Item_Master_DTO;

@Controller
@RequestMapping("/add_invoice")
public class Add_Inoice {
	
	@Autowired
	DAO_Item_Master_Service idao;
	
	@Autowired
	DAO_Invoice_Service invdao;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gettMethod(ModelAndView mandv,HttpServletRequest request)
	{
        HttpSession session = request.getSession();
		
		List<Item_Master_DTO> items =idao.all_items();
		int len = items.size();

		int[][] cart = new int[len][2];
		for(int i=0;i<len;i++)
		{
			cart[i][0] = i+1;
			cart[i][1] = Integer.parseInt(request.getParameter(String.valueOf(i+1)));
		}
		
		for(int i=0; i<len; i++)
		{
			System.out.println(cart[i][0]+"    "+ cart[i][1] );
			
		}
		session.setAttribute("cart", cart);
		//HttpSession session = request.getSession();
		//int cart[][] = (int[][])session.getAttribute("cart");
		List<Integer> ilist = new ArrayList<Integer>();
		List<Float> flist = new ArrayList<Float>();
		int userid = (int) session.getAttribute("userid");
		//List<Item_Master_DTO> items =idao.all_items();
		//int len = items.size();
		System.out.println("user id = "+userid);
		System.out.println("length = "+len);
		for(int i=0; i<len; i++)
		{
			
				
			if(cart[i][1]!=0)
			{
			ilist.add(cart[i][0]);
			flist.add((float)cart[i][1]);
			}
		}
		for(int i : ilist)
			System.out.println(i);
		for(float f : flist)
			System.out.println(f);
		if(flist.size()>0)
		{
		invdao.create_invoice(userid, ilist, flist);
		int useid = (int) session.getAttribute("userid");
		System.out.println("The PDF for the User id "+useid);
		List<Invoice_Master_DTO> masterdto = invdao.gett_all_invoice_single_user(useid);
		Iterator<Invoice_Master_DTO> iter1 = masterdto.iterator();
		int max = 0;
		while(iter1.hasNext())
		{	int temp = iter1.next().getInvno();
			if(max <= temp)
				max = temp;
		}
		System.out.println("the invoice number = "+max);
		Invoice_Master_DTO invdto1 = invdao.get_inv_by_invno(max);
		
		
		
		List<Invoice_Transaction_DTO> transdto = invdto1.getInv_trans();
		Iterator<Invoice_Transaction_DTO> iter = transdto.iterator();
		float total = 0f;
		while(iter.hasNext())
		{
		Invoice_Transaction_DTO inv = iter.next();	
			total = total+(inv.getQty()*inv.getItemdto().getPrize());
		}
		System.out.println("Total = "+total);
		mandv.addObject("total", total);
		mandv.addObject("iterr", transdto);
		mandv.setViewName("PDF");
		return mandv;
		
	}
	else
	{
		String info = "Please Select atleast ONE Item and click Buy to make Purchase";
		List<Item_Master_DTO> iter = (List<Item_Master_DTO>) session.getAttribute("itemss");
		
		mandv.addObject("info", info);
		mandv.addObject("shopping", iter);
		mandv.setViewName("Shopping");
		return mandv;
	}
		
	}
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView postMethod(ModelAndView mandv)
//	{
//		return mandv;
//		
//	}
}
