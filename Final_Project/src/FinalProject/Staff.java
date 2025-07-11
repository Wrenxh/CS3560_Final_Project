package FinalProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.time.*;
import java.time.temporal.ChronoUnit;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")	
	private String name;
	
	@ManyToMany(mappedBy = "student", cascade= {CascadeType.PERSIST})
	private List<Student> students;
	

	@ManyToMany(mappedBy = "loan", cascade= {CascadeType.PERSIST})
	private List<Loan> loans;
	
	@ManyToMany(mappedBy = "book", cascade= {CascadeType.PERSIST})
	private List<Book> books;
	
	@ManyToMany(mappedBy = "copy", cascade= {CascadeType.PERSIST})
	private List<Copy> copies;
	
	public Staff(String n) {
		this.name = n;
	}
	
	public void addLoan(Loan l) {
		
		if (loans == null) {
			loans = new ArrayList<>();
		}
		
	    if (!loans.contains(l)) {
	    	loans.add(l);
	    }			
		
	}
	
	public void deleteLoan(Loan l) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
	    if (!students.contains(l)) {
	    	students.remove(l);
	    }		
		
	}
	
	public void addStudent(Student s) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
	    if (!students.contains(s)) {
	    	students.add(s);
	    }		
		
	}
	
	public void deleteStudent(Student s) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
	    if (!students.contains(s)) {
	    	students.remove(s);
	    }		
		
	}
	
	public void addBook(Book b) {
		
		if (students == null) {
			books = new ArrayList<>();
		}
		
	    if (!students.contains(b)) {
	    	books.add(b);
	    }		
		
	}
	
	public void deleteBook(Book b) {
		
		if (students == null) {
			books = new ArrayList<>();
		}
		
	    if (!students.contains(b)) {
	    	books.remove(b);
	    }		
		
	}
	
	public void addCopy(Copy c) {
		
		if (students == null) {
			copies = new ArrayList<>();
		}
		
	    if (!students.contains(c)) {
	    	copies.add(c);
	    }		
		
	}
	
	public void deleteCopy(Copy c) {
		
		if (students == null) {
			copies = new ArrayList<>();
		}
		
	    if (!students.contains(c)) {
	    	copies.remove(c);
	    }		
		
	}
}