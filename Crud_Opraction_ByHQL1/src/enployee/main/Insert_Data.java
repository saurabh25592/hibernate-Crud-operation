package enployee.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import enployee.entity.Employee;

public class Insert_Data {

	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();	
		
		
		String insert="insert into employee(name,salary,age)values(:myname,:salary,:age)";	
	    MutationQuery query=ss.createNativeMutationQuery(insert);
	    query.setParameter("myname", "hari");
	    query.setParameter("salary", "778899000");
	    query.setParameter("age", 80);
	    query.executeUpdate();
	    
	    System.out.println("data is inserted.....");
	    tr.commit();
	    ss.close();

	    
	}	
}
