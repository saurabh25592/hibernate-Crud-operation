package enployee.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import enployee.entity.Employee;

public class Fletch_Single_Data {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		
		//fletch single record with hql query 
		String fletchquery = "from Employee where id=: myid";
		Query<Employee> query = ss.createQuery(fletchquery, Employee.class); 
		query.setParameter("myid", 2);//
		Employee e = query.getSingleResult();//it used to fletch single  record 
		System.out.println("single record is fletch......");
		System.out.println(e);
		
		tr.commit();
		ss.close();

	}
}
