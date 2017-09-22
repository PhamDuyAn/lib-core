package fresher.Cassandra.Obj;

import java.util.Date;

public class Student {
	private int idStudents;
	private String addressStudents;
	private Date dateStudents;
	private String nametudents;
	private String sex;
	private int phone;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdStudents() {
		return idStudents;
	}

	public void setIdStudents(int idStudents) {
		this.idStudents = idStudents;
	}

	public String getAddressStudents() {
		return addressStudents;
	}

	public void setAddressStudents(String addressStudents) {
		this.addressStudents = addressStudents;
	}

	public Date getDateStudents() {
		return dateStudents;
	}

	public void setDateStudents(Date dateStudents) {
		this.dateStudents = dateStudents;
	}

	public String getNametudents() {
		return nametudents;
	}

	public void setarg0Nametudents(String nametudents) {
		this.nametudents = nametudents;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Student(int idStudents, String addressStudents, Date dateStudents, String nametudents, String sex, int phone,
			String email) {
		super();
		this.idStudents = idStudents;
		this.addressStudents = addressStudents;
		this.dateStudents = dateStudents;
		this.nametudents = nametudents;
		this.email = email;
		this.sex = sex;
		this.phone = phone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
