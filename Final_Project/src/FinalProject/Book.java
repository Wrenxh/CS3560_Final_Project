package FinalProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="isbn")
	private int isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="author")
	private String author;
	
	@Column(name="pages")
	private int pgs;
	
	@Column(name="publisher")
	private String pub;
	
	@Column(name="pubDate")
	private Date pubDate;
	
	@Column(name="avalible")
	private Boolean isAvalible;
	
	@Column(name="copies")
	private int numCopies;
	
	@ManyToMany(mappedBy = "loan", cascade= {CascadeType.PERSIST})
	private List<Loan> loans;
	
	public Book(String t, String d, String a, int pg, String pu, Date pd, Boolean av, int c) {
		this.title = t;
		this.desc = d;
		this.author = a;
		this.pgs = pg;
		this.pub = pu;
		this.pubDate = pd;
		this.isAvalible = av;
		this.numCopies = c;
	}

	public int getISBN() {
		return isbn;
	}

	public void setISBN(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String t) {
		this.title = t;
	}
	
	public String getDescription() {
		return desc;
	}

	public void setDescription(String d) {
		this.desc = d;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String a) {
		this.author = a;
	}
	
	public int getPages() {
		return pgs;
	}

	public void setPages(int p) {
		this.pgs = p;
	}
	
	public String getPublisher() {
		return pub;
	}

	public void setPublisher(String p) {
		this.pub = p;
	}
	
	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date d) {
		this.pubDate = d;
	}
	
	public Boolean getAvalible() {
		return isAvalible;
	}

	public void setAvalible(Boolean a) {
		this.isAvalible = a;
	}
	
	public int getNumCopies() {
		return numCopies;
	}

	public void setNumCopies(int c) {
		this.numCopies = c;
	}
	
	

	public List<Loan> getLoan() {
		return loans;
	}

	public void setLoan(List<Loan> l) {
		this.loans = l;
	}

	public void addToLoan(Loan l) {
		
		if (loans == null) {
			loans = new ArrayList<>();
		}
		
	    if (!loans.contains(l)) {
	    	loans.add(l);
	    	l.addBook(this);
	    }			
		
	}	
	
	@Override
	public String toString() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return "isbn: " + isbn +
	            ", title: " + title +
	            ", description: " + desc +
	            ", author: " + author +
	            ", pages: " + pgs +
	            ", publisher: " + pub +
	            ", pubDate: " + formatter.format(pubDate) +
	            ", isAvailable: " + isAvalible +
	            ", numberOfCopies: " + numCopies;
	}
	
}
