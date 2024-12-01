package hospital.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import hospital.entity.Patient;

public class Insert {

    public static void main(String[] args) {

        // Setting up the configuration and session factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Patient.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        // Corrected native SQL query (assuming column names are correct in the table)
        String sql = "INSERT INTO Patient_Details(disease, age, city, name) VALUES(:disease, :age, :city, :name)";
        
        // Using NativeQuery instead of MutationQuery
        MutationQuery query = ss.createNativeMutationQuery(sql);
        query.setParameter("name", "dinesh");
        query.setParameter("city", "pune");
        query.setParameter("age", 21);
        query.setParameter("disease", "tb");
        
        query.executeUpdate();

        System.out.println("Data inserted successfully.");
        tr.commit();
        
        // Closing session and factory
        ss.close();
        sf.close();
    }
}
