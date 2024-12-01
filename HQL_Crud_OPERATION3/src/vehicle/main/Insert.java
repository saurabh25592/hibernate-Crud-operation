package vehicle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import vehicle.entity.Vehicle;

public class Insert {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hql="insert into  Vehicle(car_id,model_name,brand_name,price,color) values(:car_id,:model_name,:brand_name,:price,:color) ";
		MutationQuery query=ss.createMutationQuery(hql);
		
		query.setParameter("car_id", 5);
		query.setParameter("model_name", "ioi");
		query.setParameter("brand_name", "tata");
		query.setParameter("price", 1233);
		query.setParameter("color", "green");
		query.executeUpdate();
		
		tr.commit();
		ss.close();
		
		
	}

}
