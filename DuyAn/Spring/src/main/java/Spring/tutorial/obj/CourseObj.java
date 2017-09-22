package Spring.tutorial.obj;

import java.util.Date;

public class CourseObj {

	private int idCourse;
	private String nameCourse;
	private Date startDay;
	private Date endDay;
	private int numbers;

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public CourseObj() {

	}

	public CourseObj(int idCourse, String nameCourse, Date startDay, Date endDay, int numbers) {
		super();
		this.idCourse = idCourse;
		this.nameCourse = nameCourse;
		this.startDay = startDay;
		this.endDay = endDay;
		this.numbers = numbers;
	}

}
