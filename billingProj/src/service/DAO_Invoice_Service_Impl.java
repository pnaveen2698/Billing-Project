package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DAO_Invoice_Master;
import dao.DAO_Invoice_Transaction;
import dao.DAO_Item_Master;
import dao.DAO_User_Master;

@Component
@Controller
@RequestMapping("/invoice")
public class DAO_Invoice_Service_Impl implements DAO_Invoice_Service{

	@Autowired
	DAO_User_Master udao;
	
	@Autowired
	DAO_Invoice_Master masterdao;
	
	@Autowired
	DAO_Invoice_Transaction invdao;
	
	@Autowired
	DAO_Item_Master idao;
	
	
	@Override
	public void create_invoice(int uid, List<Integer> itemno, List<Float> qty) {
		Invoice_Master_DTO masterdto = new Invoice_Master_DTO();
		
		System.out.println("Hell hello hello : "+ itemno.get(0) +"   "+qty.get(0));
		float total = 0f;
		User_Master_DTO udto=udao.get_user_by_uid(uid);
		System.out.println("Thos is my name = "+udto.getUsername());
		masterdto.setUser(udto);
		masterdto.setDate(new java.util.Date());
		masterdto.setTotal(total);
		masterdto.setInv_trans(null);
		masterdao.add_invoice(masterdto);
		System.out.println("Invoice master obj = "+masterdao.get_invoice_by_invoiceid(1).getInv_trans());
		List<Invoice_Transaction_DTO> obj = new ArrayList<Invoice_Transaction_DTO>();
		for(int i=0; i<itemno.size(); i++ )
		{
			Invoice_Transaction_DTO invdto = new Invoice_Transaction_DTO();
			invdto.setItemdto(idao.get_item_by_id(itemno.get(i)));
			System.out.println(" i bought "+idao.get_item_by_id(itemno.get(i)));
			invdto.setQty(qty.get(i));
			System.out.println(" i bought "+qty.get(i)+" amount  "+idao.get_item_by_id(itemno.get(i)) );
			invdto.setInvdto(masterdto);
			total = total+(idao.get_price(itemno.get(i))*qty.get(i));
			masterdto.setTotal(total);
			obj.add(invdto);
			invdao.add_invoice(invdto);
			System.out.println("Invoice transaction updated...");
		}
		masterdto.setInv_trans(obj);
		masterdao.update_invoice(masterdto);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void test()
	{
//		System.out.println("Add invoice going to get started...");
//		int uid = 1;
//		List<Integer> itemno = new ArrayList<Integer>();
//		itemno.add(1);
//		itemno.add(2);
//		
//		List<Float> qty = new ArrayList<Float>();
//		qty.add(5f);
//		qty.add(10f);
//		create_invoice(uid, itemno, qty);
//		get_total_invoice();
		get_invoice_for_single_user(1);
		//get_invoice_between_dates("2020-12-17", "2020-12-20");
	}

	@Override
	public Invoice_Master_DTO get_invoice_for_single_user(int userid) {
		Invoice_Master_DTO masterdto;
		User_Master_DTO user = udao.get_user_by_uid(userid);
		System.out.println("The user  = " +user.getUsername()+" has bought the gollowing items...");
		masterdto = (Invoice_Master_DTO) masterdao.get_invoice_for_single_customer(user);
		System.out.println("Something is printing = "+masterdto.getInvno() +"     "+masterdto.getTotal());
		Iterator<Invoice_Transaction_DTO> iter = masterdto.getInv_trans().iterator();
		while(iter.hasNext())
		{
			Invoice_Transaction_DTO invdto = iter.next();
			float quantity = invdto.getQty();
			Item_Master_DTO item = invdto.getItemdto();
			float prize = item.getPrize();
			System.out.print("   Item Name = "+item.getItemdesc());
			System.out.print("   Item No = "+item.getItemno());
			System.out.print("   Price = "+prize);
			System.out.print("   Unit = "+item.getUnit());
			System.out.print("   Item Category = "+item.getCategories());
			System.out.print("   Quantiy = "+quantity);
			System.out.println("    Total = "+(quantity*prize));
		}
		return masterdto;
	
		}

	@Override
	public List<Invoice_Master_DTO> get_total_invoice() {

		List<Invoice_Master_DTO> masterdto = (List<Invoice_Master_DTO>) masterdao.get_all_invoice();
		Iterator<Invoice_Master_DTO> iter = masterdto.iterator();
		while(iter.hasNext())
		{
			Invoice_Master_DTO master = iter.next();
			User_Master_DTO user = master.getUser();
			System.out.print("     User ID = "+user.getUserid());
			System.out.print("     Invoice Number = "+master.getInvno());
			System.out.println("     Total  ="+master.getTotal());
		}
		
		return masterdto;
	}

	@Override
	public List<Invoice_Master_DTO> get_invoice_between_dates(Date from, Date to) {

		System.out.println(from+" : "+to);

		List<Invoice_Master_DTO> masterdto = (List<Invoice_Master_DTO>) masterdao.get_invoice_between_two_dates(from,to);
		Iterator<Invoice_Master_DTO> iter = masterdto.iterator();
		while(iter.hasNext())
		{
			Invoice_Master_DTO master = iter.next();
			User_Master_DTO user = master.getUser();
			System.out.println("User ID = "+user.getUserid());
			System.out.println("Invoice Number = "+master.getInvno());
			System.out.println("Total  ="+master.getTotal());
		}
		return masterdto;
	}

	@Override
	public List<Invoice_Master_DTO> gett_all_invoice_single_user(int userid) {
		
		List<Invoice_Master_DTO> masterdto = masterdao.get_all_invoice_for_single_user(userid);
		
		Iterator<Invoice_Master_DTO> iter = masterdto.iterator();
		while(iter.hasNext())
		{
			Invoice_Master_DTO master = iter.next();
			User_Master_DTO user = master.getUser();
			System.out.println("User ID = "+user.getUserid());
			System.out.println("Invoice Number = "+master.getInvno());
			System.out.println("Total  ="+master.getTotal());
		}
		return masterdto;
	}

	@Override
	public Invoice_Master_DTO get_inv_by_invno(int invno) {
		// TODO Auto-generated method stub
		return masterdao.get_invoice_by_invoiceid(invno);
	}
		
		
		

}
