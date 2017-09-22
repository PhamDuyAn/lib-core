package Spring.tutorial.obj;

import java.util.Date;

public class StudentObj {

	private Integer idStudents;
	private String NameStudents;
	private Date DateStudents;
	private String Sex;
	private String Address;

	public Integer getIdStudents() {
		return idStudents;
	}

	public void setIdStudents(Integer idStudents) {
		this.idStudents = idStudents;
	}

	public String getNameStudents() {
		return NameStudents;
	}

	public void setNameStudents(String nameStudents) {
		NameStudents = nameStudents;
	}

	@Override
	public String toString() {
		return "StudentObj [idStudents=" + idStudents + ", NameStudents=" + NameStudents + ", DateStudents="
				+ DateStudents + ", Sex=" + Sex + ", Address=" + Address + "]\n";
	}

	public Date getDateStudents() {
		return DateStudents;
	}

	public void setDateStudents(Date dateStudents) {
		DateStudents = dateStudents;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public StudentObj() {

	}

	public StudentObj(Integer idStudents, String nameStudents, Date dateStudents, String sex, String address) {
		super();
		this.idStudents = idStudents;
		this.NameStudents = nameStudents;
		this.DateStudents = dateStudents;
		this.Sex = sex;
		this.Address = address;
	}

}
