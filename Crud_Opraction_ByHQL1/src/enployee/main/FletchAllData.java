package enployee.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import enployee.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;

public class FletchAllData {

	public static void main(String[] args) {
		
	Configuration cfg=new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Employee.class);
	
	SessionFactory sf=cfg.buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tr=ss.beginTransaction();
	
	String hql="from Employee";
	
	Query<Employee> query=ss.createQuery(hql,Employee.class);
	List<Employee> list =query.getResultList();
	
	for (Employee employee : list) {
		System.out.println(employee);	
	}
	
	}
}
