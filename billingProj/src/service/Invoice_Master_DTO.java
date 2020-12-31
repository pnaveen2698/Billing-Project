package service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "Invoice_Master")
public class Invoice_Master_DTO  implements Serializable{
	private int invno;
	private float total;
	private Date date;
	private User_Master_DTO user;
	private List<Invoice_Transaction_DTO> inv_trans;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invdto")
	public List<Invoice_Transaction_DTO> getInv_trans() {
		return inv_trans;
	}
	public void setInv_trans(List<Invoice_Transaction_DTO> inv_trans) {
		this.inv_trans = inv_trans;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoiceno" , unique = true)
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	@Column(name = "total")
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date",nullable = false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User_Master_DTO getUser() {
		System.out.println(this.user);
		return user;
	}
	public void setUser(User_Master_DTO user) {
		System.out.println("Set"+user);
		this.user = user;
	}
	@Override
	public String toString() {
		return "Invoice_Master_DTO [invno=" + invno + ", total=" + total + ", date=" + date + ", user=" + user + "]";
	}
	
}
