package FinalProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Book.class).
                addAnnotatedClass(Copy.class).
                addAnnotatedClass(Staff.class).
                addAnnotatedClass(Loan.class).
                buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Loan l1 = session.get(Loan.class, 1);
			
			Student s1 = session.get(Student.class, 2);
			
			Book b1 = session.get(Book.class, 3);
			
			
			session.delete(l1);
			session.delete(s1);
			
			session.getTransaction().commit();			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
		
	}
	
}
