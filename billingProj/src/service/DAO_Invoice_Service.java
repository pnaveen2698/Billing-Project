package service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public interface DAO_Invoice_Service {
	public void create_invoice(int uid, List<Integer> itemno, List<Float> qty);
	public Invoice_Master_DTO get_invoice_for_single_user(int userid);
	public List<Invoice_Master_DTO> get_total_invoice();
	public  Invoice_Master_DTO get_inv_by_invno(int invno);
	public List<Invoice_Master_DTO> get_invoice_between_dates(Date from, Date to);
	public  List<Invoice_Master_DTO>  gett_all_invoice_single_user(int userid);
}
