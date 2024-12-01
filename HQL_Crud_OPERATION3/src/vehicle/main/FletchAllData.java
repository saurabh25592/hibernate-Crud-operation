package vehicle.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import vehicle.entity.Vehicle;

public class FletchAllData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Vehicle";
		Query<Vehicle> query = ss.createQuery(hqlQuery, Vehicle.class);
		List<Vehicle> list = query.getResultList();
		
		for (Vehicle vehicle : list) {
			System.out.println(vehicle);
		}

	}

}
