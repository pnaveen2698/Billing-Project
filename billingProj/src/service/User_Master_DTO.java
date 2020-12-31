package service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "User_Master")
public class User_Master_DTO implements Serializable{
	private int userid;
	private String username;
	private String password;
	private String roll;
	private int flag;
	private String addresses;
public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	//	private Invoice_Master_DTO invoices;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid",unique = true,nullable = false)
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name = "username",nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password",nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "flag",nullable = false)
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Column(name = "roll",nullable = false)
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
//	public Set<User_Address_DTO> getAddresses() {
//		return addresses;
//	}
//	public void setAddresses(Set<User_Address_DTO> addresses) {
//		this.addresses = addresses;
////	}
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
//	public Invoice_Master_DTO getInvoices() {
//		return invoices;
//	}
//	public void setInvoices(Invoice_Master_DTO invoices) {
//		this.invoices = invoices;
//	}
//	@Override
//	public String toString() {
//		return "User_Master_DTO [userid=" + userid + ", username=" + username + ", password=" + password + ", roll="
//				+ roll + ", flag=" + flag + ", addresses=" + addresses + ", invoices=" + invoices + "]";
//	}
//	
}
