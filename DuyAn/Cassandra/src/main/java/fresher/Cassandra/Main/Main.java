package fresher.Cassandra.Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fresher.Cassandra.Dao.CourseDao;
import fresher.Cassandra.Dao.MethodDao;
import fresher.Cassandra.Dao.StudentDao;
import fresher.Cassandra.Obj.Course;
import fresher.Cassandra.Obj.Student;

public class Main {
	public static void main(String[] args) throws ParseException {

		StudentDao student = new StudentDao();
		List<Student> liststudent = student.ListStudent();
		System.out.println("------------------Show STUDENT---------------------");// Student
		for (Student stu : liststudent) {
			System.out.println(stu.getIdStudents());
		}
		DateFormat datebirth = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = "1999-10-10";
		Date date = datebirth.parse(stringDate);
		java.sql.Date sql = new java.sql.Date(date.getTime());
		try {
			Student stu = new Student(7, "ND", sql, "An", "Lesbian", 52154, "phamduyan9x@gmail.com");//
			student.addStudent(stu);
			System.out.println("Add student successful");
		} catch (Exception e) {
			System.out.println("Add student erro: " + e);
		}
		try {
			Student stu = new Student(2, "NDinh", sql, "An", "Lesbian", 52154, "phamduyan9x@gmail.com");
			student.editStudent(stu);
			System.out.println("Edit student successful");
		} catch (Exception e) {
			System.out.println("Edit student erro: " + e);
		}
		try {
			student.deleteStudent(7);
			System.out.println("Delete student successful");
		} catch (Exception e) {
			System.out.println("Delete student erro: " + e);
		}
		System.out.println("------------------Show COURSE---------------------");// Course
		CourseDao cour = new CourseDao();
		List<Course> listcourse = cour.ListCourse();
		for (Course course : listcourse) {
			System.out.println(course.getNameCourse());
			System.out.println(course.getNumbers());
		}
		Course course = new Course(6, "Fresher C/C++", "2017-9-9", "2017-12-12", 30);
		try {
			cour.addCourse(course);
			System.out.println("add course successfull");
		} catch (Exception e) {
			System.out.println("Add Erro: " + e);
		}
		try {
			Course cor = new Course(2, "Fresher C/C+", "2017-9-9", "2017-12-12", 25);
			cour.editCourse(cor);
			System.out.println("Edit course successfull");

		} catch (Exception e) {
			System.out.println("Edit course Erro: " + e);
		}
		try {
			cour.deleteCourse(6);
			System.out.println("Delete course successfull");
		} catch (Exception e) {
			System.out.println("Delete  course Erro: " + e);
		}
		System.out.println("--------------Show student and course where idstudent------------");// Method
		MethodDao mt = new MethodDao();
		mt.ShowStudentandCourse(2);
		try {
			mt.register(4, 4,"2017-9-15");
			System.out.println("Register course successfull");
		} catch (Exception e) {
			System.out.println("Register course erro: " + e);
		}
		try {
			mt.cancle(4, 4);
			System.out.println("Cancle course successfull");
		} catch (Exception e) {
			System.out.println("Cancle course erro: " + e);
		}

	}
}
