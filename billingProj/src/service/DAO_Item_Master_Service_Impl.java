package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.DAO_Item_Master;

@Component
public class DAO_Item_Master_Service_Impl implements DAO_Item_Master_Service {
	@Autowired
	DAO_Item_Master idao;
	@Override
	public void add_item(String itemdesc, String unit, String category, float price,String image) {
		idao.add_item(itemdesc, unit, category, price, image);
		
	}
	@Override
	public List<Item_Master_DTO> all_items() {
		return idao.all_items();	
	}
	

}
