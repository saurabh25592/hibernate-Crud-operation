package enployee.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.spi.MutableQueryOptions;

import enployee.entity.Employee;

public class Update {

	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();	
		
		String hql="update Employee set name=:Ename, age=: Eage where id=:Emyid ";
		//
		MutationQuery  query=ss.createMutationQuery(hql);
		query.setParameter("Ename", "hari");
		query.setParameter("Eage", 67);
		
		query.setParameter("Emyid", 8);
		query.executeUpdate();
		
		System.out.println("data is updated....");
		tr.commit();
		ss.close();
		
		
		
		
		
	}
	
}
