package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import service.Invoice_Transaction_DTO;

@Component
public interface DAO_Invoice_Transaction {
	public void add_invoice(Invoice_Transaction_DTO idto);
	public List<Invoice_Transaction_DTO> get_invoice_for_single_user(int userid);
	public void delete_items_for_invno();
}
