package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HibernateUtility;


import service.User_Master_DTO;
@Component
@Controller
@RequestMapping("/userr")
public class DAO_User_Master_Impl implements DAO_User_Master{
	
	
	@Autowired
	private HibernateUtility hibernateUtility;
	
	public HibernateUtility getHibernateUtility() {
		return hibernateUtility;
	}

	public void setHibernateUtility(HibernateUtility hibernateUtility) {
		this.hibernateUtility = hibernateUtility;
	}
	

	
	@Override
	public String add_user(String uname, String password, String role,String address  ) {
		Session session=getHibernateUtility().currentSession();
		User_Master_DTO udto = new User_Master_DTO();
		System.out.println("User is adding into the database...");
		udto.setFlag(0);
		udto.setPassword(password);
		udto.setRoll(role);
		udto.setAddresses(address);
		//udto.setUserid(101);
		udto.setUsername(uname);

		Transaction tx = session.beginTransaction();
		try {
			session.save(udto);
			tx.commit();
			//return 1;
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			//return 0;
		}
		return "User added successfully";
	}
	
	
	
	
@Override
public User_Master_DTO update_user(String uname, int flag) {
	
	Session session=getHibernateUtility().currentSession();
	Criteria criteria = session.createCriteria(User_Master_DTO.class);
    criteria.add(Restrictions.eq("username", uname));
   
    User_Master_DTO udto = (User_Master_DTO)criteria.uniqueResult();
    udto.setFlag(flag);
    System.out.println("Name = "+udto.getUsername());
    Transaction tx = session.beginTransaction();
	try {
		session.save(udto);
		tx.commit();
		//return 1;
	}catch(Exception e) {
		e.printStackTrace();
		tx.rollback();
		//return 0;
	}
	return udto;
}



	@Override
	public User_Master_DTO get_user_by_name(String uname) {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(User_Master_DTO.class);
        criteria.add(Restrictions.eq("username", uname));
        
        return  (User_Master_DTO)criteria.uniqueResult();
	}
	@Override
	public List<User_Master_DTO> get_all_users() {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(User_Master_DTO.class);
		List<User_Master_DTO> list = (List<User_Master_DTO>)criteria.list();
		for(User_Master_DTO e:list)
			System.out.println(e.getUserid()+" : "+e.getUsername()+" : "+e.getPassword());
		return list;
	}
	
	
	
	@Autowired
	public  User_Master_DTO udto;
	@RequestMapping(method = RequestMethod.GET)
	public void test()
	{
		//update_user("Naveen",0);
		add_user("Naveen","naveen","user","Karur");
//		User_Master_DTO udto =  get_user_by_name("Naveen");
//		System.out.println("My name = "+udto.getUsername());
		get_all_users();
	}

	@Override
	public User_Master_DTO get_user_by_uid(int uid) {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(User_Master_DTO.class);
        criteria.add(Restrictions.eq("userid", uid));
        
        return  (User_Master_DTO)criteria.uniqueResult();

	}
	

}
