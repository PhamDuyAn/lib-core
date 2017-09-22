package HibernateTutorial.HibernateTutorial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import org.o7planning.tutorial.hibernate.HibernateUtils;
//import org.o7planning.tutorial.hibernate.entities.Employee;
@Entity
@Table(name = "course",
   uniqueConstraints = { @UniqueConstraint(columnNames = { "idCourse" }) })
public class Course {
	
	private int idCourse;
	private String NameCourse;
	private String  StartDay; 
	private String EndDay; 
	private int Numbers;
	
	@Id
	 @Column(name = "idCourse")
	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	
	@Column(name = "NameCourse", length = 45, nullable = false)
	public String getNameCourse() {
		return NameCourse;
	}

	public void setNameCourse(String namecourse) {
		NameCourse = namecourse;
	}

	@Column(name = "StartDay", length = 10, nullable = false)
	public String getStartDay() {
		return StartDay;
	}

	public void setStartDay(String startDay) {
		StartDay = startDay;
	}

	
	@Column(name = "EndDay", length = 10, nullable = false)
	public String getEndDay() {
		return EndDay;
	}

	public void setEndDay(String endDay) {
		EndDay = endDay;
	}

	@Column(name = "Numbers", nullable = false)
	public int getNumbers() {
		return Numbers;
	}

	public void setNumbers(int numbers) {
		Numbers = numbers;
	}

	public Course() {}
	
	public Course(int idCourse,String NameCourse,String StartDay,String EndDay,int Numbers) {
		this.idCourse=idCourse;
		this.NameCourse=NameCourse;
		this.StartDay=StartDay;
		this.EndDay=EndDay;
		this.Numbers=Numbers;
	}
	
	
}
