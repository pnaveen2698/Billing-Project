package dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HibernateUtility;

import controller.User;
import service.Invoice_Master_DTO;
import service.Invoice_Transaction_DTO;
import service.User_Master_DTO;

@Controller
@Component
@RequestMapping("/invmaster")
public class DAO_Invoice_Master_Impl implements DAO_Invoice_Master {

	@Autowired
	DAO_User_Master udao; 

	@Autowired
	private HibernateUtility hibernateUtility;
	
	public HibernateUtility getHibernateUtility() {
		return hibernateUtility;
	}

	public void setHibernateUtility(HibernateUtility hibernateUtility) {
		this.hibernateUtility = hibernateUtility;
	}
	
	@Override
	public List<Invoice_Transaction_DTO> get_invoice_by_invno(int invno) {
		
		Session session=getHibernateUtility().currentSession();
		Criteria criteria =session.createCriteria(Invoice_Master_DTO.class);
		criteria.add(Restrictions.eq("invdto",invno));
		List<Invoice_Transaction_DTO> invdto = (List<Invoice_Transaction_DTO>) criteria.list();
		for(Invoice_Transaction_DTO invdto1 : invdto)
			System.out.println(invdto1.getQty());
		return invdto;
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public void test()
	{
		//get_invoice_by_invno(101);
		//get_invoice_between_two_dates(from, to)
	}

	@Autowired
	Invoice_Master_DTO masterdto;
	@Override
	public void add_invoice(Date date, User_Master_DTO udto, List<Invoice_Transaction_DTO> invdto, float total) {
		
		Session session=getHibernateUtility().currentSession();
		masterdto.setDate(date);
		masterdto.setTotal(total);
		masterdto.setUser(udto);
		
	}

	@Override
	public void add_invoice(Invoice_Master_DTO masterdto) {
		Session session=getHibernateUtility().currentSession();

		 Transaction tx = session.beginTransaction();
		 session.save(masterdto);
			tx.commit();
//			try {
//				session.save(masterdto);
//				tx.commit();
//				//return 1;
//			}catch(Exception e) {
//				e.printStackTrace();
//				tx.rollback();
//				//return 0;
//			}
		
	}
	public User_Master_DTO get_invoice_for_single_user(User_Master_DTO userid)
	{
		User_Master_DTO udto;
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		criteria.add(Restrictions.eq("user", userid));
		udto  = (User_Master_DTO) criteria.uniqueResult(); 
		return udto;
	}

	@Override
	public void update_invoice(Invoice_Master_DTO masterdto) {
		Session session=getHibernateUtility().currentSession();

		 Transaction tx = session.beginTransaction();
		
			try {
				session.saveOrUpdate(masterdto);
				tx.commit();
				//return 1;
			}catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
				//return 0;
			}
				
	}

	@Override
	public Invoice_Master_DTO get_invoice_by_invoiceid(int invno) {
	
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		
		criteria.add(Restrictions.eq("invno", invno));
		return (Invoice_Master_DTO) criteria.list().get(0);
	}

	@Override
	public Invoice_Master_DTO get_invoice_for_single_customer(User_Master_DTO user) {
		Invoice_Master_DTO masterdto;
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		
		criteria.add(Restrictions.eq("user", user));
		masterdto =(Invoice_Master_DTO) criteria.uniqueResult();
		return masterdto;
	}

	@Override
	public Invoice_Master_DTO get_invoice_no_by_user(User_Master_DTO user) {
		Invoice_Master_DTO invdto;
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		criteria.add(Restrictions.eq("userid", user));
		invdto = (Invoice_Master_DTO) criteria.uniqueResult();
		return invdto;
	}

	@Override
	public List<Invoice_Master_DTO> get_all_invoice() {

		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		return (List<Invoice_Master_DTO>) criteria.list();
		
	}

	

	@Override
	public List<Invoice_Master_DTO> get_invoice_between_two_dates(Date from, Date to) {

		
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		criteria.add(Restrictions.between("date", from,to));
		return (List<Invoice_Master_DTO>) criteria.list();
	}

	@Override
	public List<Invoice_Master_DTO> get_all_invoice_for_single_user(int userid) {
		
		Session session=getHibernateUtility().currentSession();
		User_Master_DTO userobj = udao.get_user_by_uid(userid);
		Criteria criteria = session.createCriteria(Invoice_Master_DTO.class);
		criteria.add(Restrictions.eq("user", userobj));
		List<Invoice_Master_DTO> masterdto =  (List<Invoice_Master_DTO>)criteria.list();
		Iterator<Invoice_Master_DTO> iter = masterdto.iterator();
		while(iter.hasNext())
		{
			Invoice_Master_DTO master = iter.next();
			User_Master_DTO user = master.getUser();
			System.out.println("At dao layer....");
			System.out.print("     User ID = "+user.getUserid());
			System.out.print("     Invoice Number = "+master.getInvno());
			System.out.println("     Total  ="+master.getTotal());
		}
		return masterdto;
	}

}
