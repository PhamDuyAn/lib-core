package model;

public class student {
private int studid;
private String fullname;
private String phone;
private String email;

public int getStudid() {
	return studid;
}
public void setStudid(int studid) {
	this.studid = studid;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "student [studid=" + studid + ", fullname=" + fullname + ", phone="
			+ phone + ", email=" + email + "]";
}
public student(int studid, String fullname, String phone, String email) {
	super();
	this.studid = studid;
	this.fullname = fullname;
	this.phone = phone;
	this.email = email;
}
public student() {
	super();
	// TODO Auto-generated constructor stub
}

}
