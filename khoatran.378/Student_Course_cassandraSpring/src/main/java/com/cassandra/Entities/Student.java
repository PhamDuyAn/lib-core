package com.cassandra.Entities;

import java.sql.Date;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Student {
      @PrimaryKey
       private int Student_ID;
       private String Student_name;
       private String Gender;
       private String Email;
       private String phone;
       
	public Student() {
		super();
	}

	public Student(int student_ID, String student_name, String gender, String email, String phone) {
		super();
		Student_ID = student_ID;
		Student_name = student_name;
		Gender = gender;
		Email = email;
		this.phone = phone;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
     
	
	
       
}
