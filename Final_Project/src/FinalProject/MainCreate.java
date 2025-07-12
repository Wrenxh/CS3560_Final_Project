package FinalProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class MainCreate {
	
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

			Student stud = new Student("Elias", "630 VdP", "CS");
			
			Staff stf = new Staff("Mary");
			
            Date pub = new Date(0); 
            Date start = new Date(System.currentTimeMillis());
            long e = System.currentTimeMillis()+ 100000000;
            Date end = new Date(e);
            
            Loan l1 = new Loan(start, end, "Elias");
			
			Book bk = new Book("The Great Gatsby", "A classic novel set in the 1920s.", "JR Tolkein", 180, "Scribner", pub, true, 5);
			
            stf.addStudent(stud);
            stf.addBook(bk);
			
			l1.addBook(bk);
			
			session.persist(stud);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
	}	

}
