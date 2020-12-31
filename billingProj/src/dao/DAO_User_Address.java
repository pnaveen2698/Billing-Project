package dao;

import org.springframework.stereotype.Component;

@Component
public interface DAO_User_Address {
	public void add_address(int uid, String city, String street);
	public void delete_address(int uid, String city, String street);

}
