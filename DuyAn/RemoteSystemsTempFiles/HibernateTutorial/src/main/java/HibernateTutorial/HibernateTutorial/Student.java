package HibernateTutorial.HibernateTutorial;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

//public class CompanyName implements Serializable {
//	//...
//	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", insertable = false, updatable = false)
//	private Company company;
@Entity
@Table(name = "students",
   uniqueConstraints = { @UniqueConstraint(columnNames = { "idStudents" }) })
public class Student {

	private int idStudents;
	private String Nametudents;
	private Date DateStudents;
	private String Sex;
	private String AddressStudents;
	
	
	@Id
	 @Column(name = "idStudents" )
	public int getIdStudents() {
		return idStudents;
	}
	public void setIdStudents(int idStudents) {
		this.idStudents = idStudents;
	}

	@Column(name = "NameStudents", length = 45, nullable = false)
	public String getNametudents() {
		return Nametudents;
	}

	public void setNametudents(String nametudents) {
		Nametudents = nametudents;
	}

	@Column(name = "DateStudents", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateStudents() {
		return DateStudents;
	}
	public void setDateStudents(Date dateStudents) {
		DateStudents = dateStudents;
	}

	@Column(name = "Sex", length = 7, nullable = false)
	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	@Column(name = "AddressStudents", length = 100, nullable = false)
	public String getAddressStudents() {
		return AddressStudents;
	}

	public void setAddressStudents(String addressStudents) {
		AddressStudents = addressStudents;
	}

	public Student()
	{
		
	}
	
	public Student(int idStudent, String NameStudents,Date DateStudents,String Sex,String AddressStudent) {
		this.idStudents=idStudent;
		this.Nametudents=NameStudents;
		this.DateStudents=DateStudents;
		this.Sex=Sex;
		this.AddressStudents=AddressStudent;
	}
	

	
}
