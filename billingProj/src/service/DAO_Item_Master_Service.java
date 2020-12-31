package service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DAO_Item_Master_Service {

	public void add_item(String itemdesc, String unit, String category, float price, String image);
	public List<Item_Master_DTO> all_items();
}
