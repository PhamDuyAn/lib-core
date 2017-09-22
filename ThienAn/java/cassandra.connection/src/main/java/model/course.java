package model;

public class course {
	private int courseid;
	private String courseName;
	private String courseTime;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	@Override
	public String toString() {
		return "course [courseid=" + courseid + ", courseName=" + courseName
				+ ", courseTime=" + courseTime + "]";
	}
	public course(int courseid, String courseName, String courseTime) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.courseTime = courseTime;
	}
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
