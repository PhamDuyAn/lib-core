package fresher.Cassandra.Dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import fresher.Cassandra.Obj.Student;
import fresher.Cassandra.connection.ConnectionCassandra;

public class StudentDao {
	private Session session;

	public StudentDao() {
		super();
		ConnectionCassandra con = new ConnectionCassandra();
		con.connect("10.225.3.252", 9042);
		session = con.getSession();

	}

	public void getStudent(int id) {

		String sql = "SELECT * FROM student where idstudent='" + id + "';";

		for (Row row : session.execute(sql)) {
			System.out.println(row.toString());

		}

	}

	public List<Student> ListStudent() {

		String sql = "SELECT * FROM student ;";
		List<Student> student = new ArrayList<Student>();
		for (Row row : session.execute(sql)) {
			Student stu = new Student();
			stu.setIdStudents(row.getInt("idstudent"));
			student.add(stu);
		}
		return student;
	}

	public void addStudent(Student student) {
		String sql = "insert into student(idstudent,namestudent,datestudent,phone,sex,address,email) values " + "(" + student.getIdStudents()
				+ ",'" + student.getNametudents() + "'," + "'" + student.getDateStudents() + "'," + student.getPhone()
				+ "," + "'" + student.getSex() + "','" + student.getAddressStudents() + "','" + student.getEmail()
				+ "');";
		session.execute(sql);
	}

	public void editStudent(Student student) {
		String sql = "update student set namestudent='" + student.getNametudents() + "',datestudent='" + student.getDateStudents()
				+ "',phone = " + student.getPhone() + ",sex = '" + student.getSex() + "',email = '" + student.getEmail()
				+ "',address='" + student.getAddressStudents() + "' where idstudent = " + student.getIdStudents() + ";";
		session.execute(sql);
	}

	public void deleteStudent(int id) {
		String sql = "delete from student where idstudent=" + id + ";";
		session.execute(sql);
	}
}
