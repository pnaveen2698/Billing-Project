package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DAO_User_Master;
import dao.DAO_User_Master_Impl;
@Component
@Controller
@RequestMapping("/users")
public class DAO_User_Master_Service_Impl implements DAO_User_Master_Service {

	@Autowired
	DAO_User_Master udao;
	@Override
	
	public String check_user(String uname, String upass) {
	
		User_Master_DTO udto =  udao.get_user_by_name(uname);
		if(udto != null)
		{
		if(uname != null)
		{
			if(upass.equals(udto.getPassword()))
			{
				System.out.println("Login success!!!");
				if(udto.getRoll().equals("user")) 
				{
					System.out.println(udto.getUsername()+" is an User...");
					return "success.user";
				}
				else if(udto.getRoll().equals("admin"))
				{
					System.out.println(udto.getUsername()+" is an Admin");
					return "success.admin";
				}
				else 
					return "invalid";
			}
			else
			{
				System.out.println("Invalid username and password...");
				return "invalid";
			}
		}
		else
		{
			System.out.println("New User. Please register...");
			return "new";
		}
		}
		else
		{
			System.out.println("New User. Please register...");
			return "new";
		}
		
		//System.out.println("PAssword = "+udto.getPassword());
	}

	@Override
	public int check_flag(String uname) {
		User_Master_DTO udto =  udao.get_user_by_name(uname);
		if(udto.getFlag()==0)
		{
			System.out.println("New Loggin...");
			return 0;
		}
		else if(udto.getFlag()==1)
		{
			System.out.println("Already Login...");
			return 1;
		}
		else
		{
			System.out.println("Invalid User...");
		}
		return 2;
		
	}

	@Override
	public int update_flag(String uname, int flag) {
		User_Master_DTO udto;
		udto = udao.update_user(uname, flag);
		System.out.println( "updated user flag = "+udto.getFlag());
		return 0;
		
		
	}

	@Override
	public void register_user(String uname, String password, String role,String address) {
		System.out.println(udao.add_user(uname, password, role,address));
		//udao.add_user(uname, password, role, address);
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public void test()
	{
		check_user("afkjkl", "wfwf");
		//check_flag("Naveen");
		//update_flag("Naveen", 1);
		//register_user("Thoosi","thoosi", "user");
	}

	@Override
	public User_Master_DTO get_user_by_name(String uname) {
		
		return udao.get_user_by_name(uname);
	}
	
	

}
