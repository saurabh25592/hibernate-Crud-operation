package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hospital.entity.Patient;

public class Delete {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		
		int id=1;
		//create delete query by using Hql  Query 
		String hqlQuery="delete Patient where patient_id=: id";
		Query<Patient> query=ss.createQuery(hqlQuery);
		query.setParameter("id", id);
		query.executeUpdate();
		
		
		tr.commit();
		System.out.println("single roecord is deleted....");
		ss.close();
		
	}

}
