package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HibernateUtility;

import service.Invoice_Transaction_DTO;

@Component
public class DAO_Invoice_Transaction_Impl implements DAO_Invoice_Transaction {

	@Autowired
	private HibernateUtility hibernateUtility;
	
	public HibernateUtility getHibernateUtility() {
		return hibernateUtility;
	}

	public void setHibernateUtility(HibernateUtility hibernateUtility) {
		this.hibernateUtility = hibernateUtility;
	}
	
	
	@Override
	public void add_invoice(Invoice_Transaction_DTO idto) {
		Session session=getHibernateUtility().currentSession();
		
		Transaction tx = session.beginTransaction();
		session.save(idto);
		tx.commit();
//		try {
//			session.save(idto);
//			tx.commit();
//			//return 1;
//		}catch(Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//			//return 0;
//		}
		
	}

	@Override
	public List<Invoice_Transaction_DTO> get_invoice_for_single_user(int userid) {
		
		Session session=getHibernateUtility().currentSession();
		Criteria  criteria = session.createCriteria(Invoice_Transaction_DTO.class);
		criteria.add(Restrictions.eq("userid",userid));
		
		return (List<Invoice_Transaction_DTO>)criteria.list();
		
		
	}

	@Override
	public void delete_items_for_invno() {
		// TODO Auto-generated method stub
		
	}

}
