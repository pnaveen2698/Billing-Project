package dao;

import java.util.List;


import org.springframework.stereotype.Component;

import service.User_Master_DTO;
@Component
public interface DAO_User_Master {

	public String add_user(String uname, String password, String role,String address);
	public User_Master_DTO get_user_by_name(String uame);
	public User_Master_DTO get_user_by_uid(int uid);
	public List<User_Master_DTO> get_all_users();
	public User_Master_DTO update_user(String uname,int flag);
}
