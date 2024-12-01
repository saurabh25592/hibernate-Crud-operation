package vehicle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import vehicle.entity.Vehicle;

public class Single_Fletch_Data {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hql = "from Vehicle where car_id=: myid";
		Query<Vehicle> query = ss.createQuery(hql);
		query.setParameter("myid", 3);
		Vehicle v = query.getSingleResult();

		System.out.println(v);

		tr.commit();
		ss.close();

	}

}
