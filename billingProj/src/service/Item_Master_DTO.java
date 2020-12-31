package service;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "Item_Master")
public class Item_Master_DTO  implements Serializable{
	private int itemno;
	private String itemdesc;
	private String categories;
	private String unit;
	private float prize;
	private String image;
	//private Invoice_Transaction_DTO inv_trans;

//	public Set<Invoice_Transaction_DTO> getInv_trans() {
//		return inv_trans;
//	}
//	public void setInv_trans(Set<Invoice_Transaction_DTO> inv_trans) {
//		this.inv_trans = inv_trans;
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "itemno",unique = true)
	public int getItemno() {
		return itemno;
	}
	
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	@Column(name = "itemdesc" , nullable = false)
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	@Column(name = "categories" , nullable = false)
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	@Column(name = "unit" , nullable = false)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name = "prize" , nullable = false)
	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	
	
	@Override
	public String toString() {
		return "Item_Master [itemno=" + itemno + ", itemdesc=" + itemdesc + ", categories=" + categories + ", unit="
				+ unit + ", prize=" + prize + "]";
	}
	@Lob
	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
