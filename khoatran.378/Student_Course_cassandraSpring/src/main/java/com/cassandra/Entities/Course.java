package com.cassandra.Entities;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Course {
    
	@PrimaryKey
	 private int Course_ID;
	 private String Course_Title;
	 private String Description;
	 
	 
	public Course() {
	}


	public Course(int course_ID, String course_Title, String description) {
		Course_ID = course_ID;
		Course_Title = course_Title;
		Description = description;
	}


	public int getCourse_ID() {
		return Course_ID;
	}


	public void setCourse_ID(int course_ID) {
		Course_ID = course_ID;
	}


	public String getCourse_Title() {
		return Course_Title;
	}


	public void setCourse_Title(String course_Title) {
		Course_Title = course_Title;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}
	 
	 
	
}
