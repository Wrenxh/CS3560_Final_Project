package FinalProject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")	
	private String name;
	
	@Column(name="address")	
	private String address;
	
	@Column(name="degree")	
	private String degree;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Loan loan;

	public Student () {
		
	}

	public Student(String name, String address, String degree) {
		this.name = name;
		this.address = address;
		this.degree = degree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String n, String a, String d) {
		this.name = n;
		this.address = a;
		this.degree = d;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String d) {
		this.degree = d;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan l) {
		this.loan = l;
	}
	
	public Boolean hasLoan() {
		if(loan != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student: BroncoID: " + id + 
				", name=" + name +
				", address=" +address +
				", Degree=" + degree;
	}
	
}
