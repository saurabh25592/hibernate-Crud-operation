package vehicle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import vehicle.entity.Vehicle;


public class Delete {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hql="Delete Vehicle where car_id=: myid";
		Query<Vehicle>query=ss.createQuery(hql);
		query.setParameter("myid", 4);
		query.executeUpdate();
		
		System.out.println("data is deleted.....");
	     tr.commit();
	     ss.close();
	}
	
	
}
