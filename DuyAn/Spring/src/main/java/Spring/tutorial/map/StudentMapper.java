package Spring.tutorial.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import Spring.tutorial.obj.StudentObj;

public class StudentMapper implements RowMapper<StudentObj> {

	public StudentObj mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentObj student = new StudentObj();
		
		student.setIdStudents(rs.getInt("idStudents"));
		student.setNameStudents(rs.getString("NameStudents"));//Name CSDL
		student.setDateStudents(rs.getDate("DateStudents"));
		student.setSex("Sex");
		student.setAddress("AddressStudents");
		return student;
	}
}
