package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Shop.entity.Client;


public class Update {

	public static void main(String[] args) {
	
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Client.class);
	
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session ss=sf.openSession();
	  Transaction tr=ss.beginTransaction();
	  
	  int id=1;
	  
	  Client c=ss.get(Client.class, id);
	
	  c.setName("om");
	  c.setMobile_number(123345);
      c.setAddress("chinchwad");	
      
	  ss.merge(c);
	  tr.commit();
	  
	  System.out.println("data updated");
	  
	  ss.close();
		
	}
	
}
