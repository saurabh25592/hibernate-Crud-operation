package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hospital.entity.Patient;

public class Fletch_Single_Data {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Patient.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction(); 
		///hql
		String hql="from Patient where patient_id=: id ";
		Query <Patient> query=ss.createQuery(hql,Patient.class);
		query.setParameter("id", 5);
		Patient p=query.getSingleResult();
		
		System.out.println("fletch Single record.....");
		tr.commit();
		ss.close();
		
	}

}
