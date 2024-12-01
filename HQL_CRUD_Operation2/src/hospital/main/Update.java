package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import hospital.entity.Patient;

public class Update {

	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Patient.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hql="update  Patient_Details set city=:mycity where patient_id=:id ";
		MutationQuery query=ss.createMutationQuery(hql);	
		query.setParameter("mycity", "udaypur");
		query.setParameter("id", 2);
		query.executeUpdate();
		
		System.out.println("datta is updated....");
		
		
		
		
	}
	
}
