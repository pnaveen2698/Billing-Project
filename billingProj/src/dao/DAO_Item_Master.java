package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import service.Item_Master_DTO;

@Component
public interface DAO_Item_Master {
	//public void add_item(String itemdesc, String unit, String category, int price, byte[] image);
	public Item_Master_DTO get_item_by_id(int itemno);
	public List<Item_Master_DTO> all_items();
	public float get_price(int itemno);
	public void add_item(String itemdesc, String unit, String category, float price, String image);
}
