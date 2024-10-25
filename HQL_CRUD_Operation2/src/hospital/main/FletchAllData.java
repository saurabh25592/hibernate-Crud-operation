package hospital.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hospital.entity.Patient;

public class FletchAllData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Patient.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		//hql query
        //org.hibernate
		String hqlQuery="from Patient";
		Query<Patient> query=ss.createQuery(hqlQuery,Patient.class);
		List list= query.getResultList();
		
		for (Object patient : list) {
			System.out.println(patient);
		}
		
		
//		// using the Jakarta.persistent 
//		String hqlQuery="from Patient";
//		Query query=ss.createQuery(hqlQuery,Patient.class);
//		List<Patient> list=  query.getResultList();
//		   
//		
//		for (Object patient : list) {
//			System.out.println(patient);
//		}
	}
}