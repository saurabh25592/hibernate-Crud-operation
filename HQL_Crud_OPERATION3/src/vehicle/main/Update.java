package vehicle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import vehicle.entity.Vehicle;


public class Update {

	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Vehicle.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();	
		
		String hql="update Vehicle set car_model=:car_model, car_brand:=car_brand, price:=price where car_id=:cmyid ";
		//
		MutationQuery  query=ss.createMutationQuery(hql);
		query.setParameter("car_model", "jdhsh");
		query.setParameter("car_brand", "yuiw");
		query.setParameter("price", 6778);
		
		query.setParameter("cmyid", 2);
		query.executeUpdate();
		
		System.out.println("data is updated....");
		tr.commit();
		ss.close();
		
		
		
		
		
	}
	
}
