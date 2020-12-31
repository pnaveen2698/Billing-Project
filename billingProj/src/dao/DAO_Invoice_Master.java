package dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import service.Invoice_Master_DTO;
import service.Invoice_Transaction_DTO;
import service.User_Master_DTO;

@Component
public interface DAO_Invoice_Master {
	public List<Invoice_Transaction_DTO> get_invoice_by_invno(int invno);
	public void add_invoice(Date date, User_Master_DTO udto, List<Invoice_Transaction_DTO> invdto,float total);
	public void add_invoice(Invoice_Master_DTO masterdto);
	public void update_invoice(Invoice_Master_DTO masterdto);
	public Invoice_Master_DTO get_invoice_by_invoiceid(int invno);
	public User_Master_DTO get_invoice_for_single_user(User_Master_DTO userid);
	public Invoice_Master_DTO get_invoice_for_single_customer(User_Master_DTO userid);
	public Invoice_Master_DTO get_invoice_no_by_user(User_Master_DTO user);
	public List<Invoice_Master_DTO> get_all_invoice();
	public List<Invoice_Master_DTO> get_all_invoice_for_single_user(int userid);
	public List<Invoice_Master_DTO> get_invoice_between_two_dates(Date from, Date to);
}
 