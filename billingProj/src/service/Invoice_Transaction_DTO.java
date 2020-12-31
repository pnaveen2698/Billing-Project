package service;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//@Component
//@Entity
//@Table(name = "Invoice_Transaction")
//public class Invoice_Transaction_DTO  implements Serializable{
//
//private float qty;
//private Item_Master_DTO itemdto;
//private  Invoice_Master_DTO invdto;
//
//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
//private int rowno;  
//public int getRowno() {
//	return rowno;
//}
//
//public void setRowno(int rowno) {
//	this.rowno = rowno;
//}
//@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//@JoinColumn(name = "itemno" , nullable = true)
//public Item_Master_DTO getItemdto() {
//	return itemdto;
//}
//public void setItemdto(Item_Master_DTO itemdto) {
//	this.itemdto = itemdto;
//}
//
//@ManyToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "invno", nullable = false)
//public Invoice_Master_DTO getInvdto() {
//	return invdto;
//}
//public void setInvdto(Invoice_Master_DTO invdto) {
//	this.invdto = invdto;
//}
//
//public float getQty() {
//	return qty;
//}
//@Column(name = "quantity")
//public void setQty(float qty) {
//	this.qty = qty;
//}
//
//
//}

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="invoice_transaction")
public class Invoice_Transaction_DTO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int row_id;
	


	public int getRow_id() {
		return row_id;
	}

	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}

	public Invoice_Master_DTO getInvdto() {
		return invdto;
	}

	public void setInvdto(Invoice_Master_DTO invdto) {
		this.invdto = invdto;
	}

	public Item_Master_DTO getItemdto() {
		return itemdto;
	}

	public void setItemdto(Item_Master_DTO itemdto) {
		this.itemdto = itemdto;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invno", nullable = false)
	private Invoice_Master_DTO invdto;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "itemno", nullable = false)
	private Item_Master_DTO itemdto;
	
	@Column(name="qty", nullable=false)
	private float qty;

	
}
