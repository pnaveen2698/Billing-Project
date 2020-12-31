//package dao;
//
//import java.util.Set;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.HibernateUtility;
//
//import service.User_Address_DTO;
//import service.User_Master_DTO;
//
//@Component
//@Controller
//@RequestMapping("/address")
//public class DAO_User_Address_Impl implements DAO_User_Address {
//
//	@Autowired
//	private HibernateUtility hibernateUtility;
//	
//	public HibernateUtility getHibernateUtility() {
//		return hibernateUtility;
//	}
//
//	public void setHibernateUtility(HibernateUtility hibernateUtility) {
//		this.hibernateUtility = hibernateUtility;
//	}
//	
//	@Override
//	public void add_address(int uid, String city, String street) {
//		Session session=getHibernateUtility().currentSession();
//		User_Address_DTO udto = new User_Address_DTO();
//		Criteria criteria = session.createCriteria(User_Master_DTO.class);
//		criteria.add(Restrictions.eq("userid", uid));
//		User_Master_DTO user = (User_Master_DTO)criteria.uniqueResult();
//		Set<User_Address_DTO> addresses = user.getAddresses();
//		
//		udto.setCity(city);
//		udto.setStreet(street);
//		udto.setUser(user);
//		addresses.add(udto);
//		user.setAddresses(addresses);
//		
//		
//		Transaction tx = session.beginTransaction();
//		try {
//			session.save(user);
//			session.save(udto);
//			tx.commit();
//			//return 1;
//		}catch(Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//			//return 0;
//		}
//		
//	}
//	@RequestMapping(method = RequestMethod.GET)
//	public void test()
//	{
////		add_address(1, "Karur", "Puliyur");
////		add_address(1, "Coimbatore", "Anna Nagar");
////		add_address(1, "Chennai", "T-Nagar");
//		delete_address(1,"Karur", "Puliyur");
//	}
//
//	@Override
//	public void delete_address(int uid, String city, String street) {
//		Session session=getHibernateUtility().currentSession();
//		Criteria criteria = session.createCriteria(User_Address_DTO.class);
//		criteria.add(Restrictions.eq("street", street));
//		//criteria.add(Restrictions.eq("city", city));
//		
//		User_Address_DTO udto = (User_Address_DTO)criteria.uniqueResult();
//		System.out.println("Street = "+udto.getStreet());
//		session.delete(udto);
//		System.out.println("Deleted successful...");
//		
//		
//	}
//
//
//}
