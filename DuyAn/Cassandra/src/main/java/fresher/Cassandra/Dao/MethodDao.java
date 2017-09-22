package fresher.Cassandra.Dao;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import fresher.Cassandra.Obj.Course;
import fresher.Cassandra.Obj.Student;
import fresher.Cassandra.connection.ConnectionCassandra;

public class MethodDao {
	private Session session;

	public MethodDao() {
		super();
		ConnectionCassandra con = new ConnectionCassandra();
		con.connect("127.0.0.1", 9042);
		session = con.getSession();
		// TODO Auto-generated constructor stub
	}

	public void register(int idStudent, int idCourse, String registerday) {// register course
		String sql = "insert into register(idcourse,idstudent,registerday) values (" + idCourse + "," + idStudent + ",'"
				+ registerday + "');";
		session.execute(sql);
	}

	public void cancle(int idStudent, int idCourse) {// cancle course
		String sql = "Delete from register where idcourse = " + idCourse + " and idstudent = " + idStudent + "";
		session.execute(sql);
	}

	public void ShowStudentandCourse(int idstudent) {// show infomation course where id student
		Student st = new Student();
		Course cour = new Course();
		String student1 = null, course1 = null, registerday = null;
		String sql = "Select * from register where idstudent = " + idstudent + " ALLOW FILTERING;";
		for (Row row : session.execute(sql)) {
			st.setIdStudents(row.getInt("idstudent"));
			cour.setIdCourse(row.getInt("idcourse"));
			registerday=row.getString("registerday");

			try {
				String sql0 = "select * from student where id=" + st.getIdStudents() + " ALLOW FILTERING ;";
				for (Row row0 : session.execute(sql0)) {
					student1 = "student: " + row0.getInt("id") + "---" + row0.getString("name") + "---"
							+ row0.getInt("phone");
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
			try {
				String sql1 = "select * from course where id= " + cour.getIdCourse() + " ALLOW FILTERING;";
				for (Row row1 : session.execute(sql1)) {
					course1 = "----" + row1.getInt("id") + "---" + row1.getString("namecourse") + "---"
							+ row1.getInt("number");
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
			System.out.println(student1 + course1+"---Registerday: "+registerday);
		}
	}
}
