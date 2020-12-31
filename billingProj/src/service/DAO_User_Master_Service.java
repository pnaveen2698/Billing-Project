package service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component()
public interface DAO_User_Master_Service {

	public String check_user(String uname, String upass);
	public int check_flag(String uname);
	public int update_flag(String uname, int flag);
	public void register_user(String uname, String password, String role,String address);
	public User_Master_DTO get_user_by_name(String uname);
}
