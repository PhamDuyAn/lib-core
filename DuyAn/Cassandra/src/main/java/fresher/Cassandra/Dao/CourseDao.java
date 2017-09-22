package fresher.Cassandra.Dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import fresher.Cassandra.Obj.Course;
import fresher.Cassandra.Obj.Student;
import fresher.Cassandra.connection.ConnectionCassandra;

public class CourseDao {

	public CourseDao() {
		super();
		ConnectionCassandra con = new ConnectionCassandra();
		con.connect("10.225.3.252", 9042);
		session = con.getSession();
		// TODO Auto-generated constructor stub
	}

	private Session session;

	public void getStudent(int id) {

		String sql = "SELECT * FROM course where id='" + id + "';";

		for (Row row : session.execute(sql)) {
			System.out.println(row.toString());

		}

	}

	public List<Course> ListCourse() {

		String sql = "SELECT * FROM course;";
		List<Course> course = new ArrayList<Course>();
		for (Row row : session.execute(sql)) {
			Course cour = new Course();

			cour.setIdCourse(row.getInt("id"));
			
			cour.setNameCourse(row.getString("namecourse"));
			
			//cour.setStartDay(row.getString("startday"));
		
			//cour.setEndDay(row.getString("endday"));
			
			cour.setNumbers(row.getInt("number"));
			course.add(cour);

		}
		return course;
//		String sql = "SELECT * FROM student ;";
//		List<Student> student = new ArrayList<Student>();
//		for (Row row : session.execute(sql)) {
//			Student stu = new Student();
//			stu.setIdStudents(row.getInt("id"));
//			student.add(stu);
//		}
//		return student;
	}

	public void addCourse(Course cour) {
		String sql = "insert into course(id,namecourse,startday,endday,number) values (" + cour.getIdCourse() + ",'"
				+ cour.getNameCourse() + "','" + cour.getStartDay() + "','" + cour.getEndDay() + "',"
				+ cour.getNumbers() + ")";
		session.execute(sql);
	}

	public void editCourse(Course cour) {
		String sql = "update course set namecourse = '" + cour.getNameCourse() + "',startday='" + cour.getStartDay()
				+ "',endday = '" + cour.getEndDay() + "', number=" + cour.getNumbers() + " where id = "
				+ cour.getIdCourse() + ";";
		session.execute(sql);
	}

	public void deleteCourse(int id) {
		String sql = "delete from course where id=" + id + ";";
		session.execute(sql);
	}

}
