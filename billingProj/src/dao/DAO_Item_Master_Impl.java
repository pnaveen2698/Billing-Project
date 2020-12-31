package dao;

import java.io.File;
import java.io.FileInputStream;
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

import service.Item_Master_DTO;

@Component
@Controller
@RequestMapping("/item")
public class DAO_Item_Master_Impl implements DAO_Item_Master {

	@Autowired
	private HibernateUtility hibernateUtility;
	
	public HibernateUtility getHibernateUtility() {
		return hibernateUtility;
	}

	public void setHibernateUtility(HibernateUtility hibernateUtility) {
		this.hibernateUtility = hibernateUtility;
	}
	@Override
	public void add_item(String itemdesc, String unit, String category, float price, String image) {
		System.out.println(itemdesc +" "+ unit);
		Session session=getHibernateUtility().currentSession();
		idto.setItemdesc(itemdesc);
		idto.setCategories(category);
		idto.setPrize(price);
		idto.setUnit(unit);
		idto.setImage( image);
		Transaction tx = session.beginTransaction();
		try {
			session.save(idto);
			tx.commit();
			//return 1;
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			//return 0;
		}
		
	}

	@Autowired
	Item_Master_DTO idto;
	@Override
	public Item_Master_DTO get_item_by_id(int itemno) {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Item_Master_DTO.class);
		criteria.add(Restrictions.eq("itemno", itemno));
		idto = (Item_Master_DTO)criteria.uniqueResult();
		//System.out.println("This is "+idto.getItemdesc());
		return idto;
	}

	@Override
	public List<Item_Master_DTO> all_items() {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Item_Master_DTO.class);
		List<Item_Master_DTO> list = (List<Item_Master_DTO>)criteria.list();
//		for(Item_Master_DTO idto : list)
//			System.out.println("Name = "+idto.getItemdesc()+ " : "+"Price = "+idto.getPrize());
		return list;
		
	}

	@Override
	public float get_price(int itemno) {
		Session session=getHibernateUtility().currentSession();
		Criteria criteria = session.createCriteria(Item_Master_DTO.class);
		criteria.add(Restrictions.eq("itemno", itemno));
		idto = (Item_Master_DTO)criteria.uniqueResult();
		return idto.getPrize();
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public void test()
	{
		File file = new File("C:\\Users\\CSS\\Downloads\\Dog.png");
        byte[] image = new byte[(int) file.length()];
        	try
        	{
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(image);
            fileInputStream.close();
           
        	}catch(Exception e) {e.printStackTrace();}
        	 //add_item("Sugar", "Kg", "Grocery", 50, image);
        	 //add_item("Salt", "Kg", "Grocery", 10, image);
		//get_item_by_id(1);
		all_items();
		//get_price(1);
    }
	

}
