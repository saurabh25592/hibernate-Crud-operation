package enployee.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import enployee.entity.Employee;

public class Delete {
	
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		//hql query
        //org.hibernate
		String hqlQuery="delete Employee where id=: myid ";
		Query<Employee> query=ss.createQuery(hqlQuery);
		query.setParameter("myid", 9);
		query.executeUpdate();
		
		System.out.println("deleted single record...");
		tr.commit();
		ss.close();
		
	}
}
