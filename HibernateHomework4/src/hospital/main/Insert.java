package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Shop.entity.Client;

public class Insert {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Client.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Client p = new Client();

	p.setName("kartik");
	p.setMobile_number(343563887);
	p.setAddress("ols sangvii");

		ss.persist(p);

		System.out.println("data inserted....");
		tr.commit();
		ss.close();

	}

}
