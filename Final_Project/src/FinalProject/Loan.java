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
@Table(name="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="startDate")
	private Date start;
	
	@Column(name="endDate")
	private Date end;
	
	@Column(name="student")
	private String studName;
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="recipt",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="isbn")
			)
	private List<Book> books;	
	
	public Loan() {
		
	}
	
	public Loan(Date st, Date n, String s) {
		this.start = st;
		this.end = n;
		this.studName = s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return start;
	}

	public void setStartDate(Date d) {
		this.start = d;
	}
	
	public Date getEndDate() {
		return end;
	}

	public void setEndDate(Date d) {
		this.end = d;
	}

	public String getStudentName() {
		return studName;
	}

	public void setStudentName(String n) {
		this.studName = n;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> b) {
		this.books = b;
	}
	
	public void addBook(Book b) {
		
		if (books == null) {
			books = new ArrayList<>();
		}
		
	    if (!books.contains(b)) {
	    	books.add(b);
	    	b.addToLoan(this);
	    }		
		
	}	
	
	public Boolean isExpired() {
		
		long loanTime = ChronoUnit.DAYS.between(LocalDate.parse(start.toString()), LocalDate.parse(end.toString()));
		
		if(loanTime > 180) {
			return false;
		}
		
		else {
			return true;
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Borrower Name: " + studName +
				", Start date=" + formatter.format(start) +
				", End date=" + formatter.format(end);
	}
	
}
