package fresher.Cassandra.Obj;

import java.util.Date;

public class Course {

	private int idCourse;
	private String endDay;
	private String nameCourse;
	private int numbers;
	private String startDay;
	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getNameCourse() {
		return nameCourse;
	}
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public Course(int idCourse, String nameCourse, String startDay,String endDay,  int numbers) {
		super();
		this.idCourse = idCourse;
		this.endDay = endDay;
		this.nameCourse = nameCourse;
		this.numbers = numbers;
		this.startDay = startDay;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
