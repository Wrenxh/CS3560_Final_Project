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
@Table(name="copy")
public class Copy extends Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="barcode")
	private int barCode;
	
	public Copy(String t, String d, String a, int pg, String pu, Date pd, Boolean av, int c, int bc) {
		super(t, d, a, pg, pu, pd, av, c);
		this.barCode = bc;
	}
	
}