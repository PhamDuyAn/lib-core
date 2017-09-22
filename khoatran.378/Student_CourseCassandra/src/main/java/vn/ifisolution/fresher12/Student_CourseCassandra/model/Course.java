package vn.ifisolution.fresher12.Student_CourseCassandra.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Table;
@Table
public class Course {
	@Id
	private int id;
	private String courseTitle;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(int id, String courseTitle, String description) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.description = description;
	}
	public Course() {
		super();
	}
	

}
