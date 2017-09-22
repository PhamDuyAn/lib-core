package Spring.tutorial.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Spring.tutorial.obj.CourseObj;

public class CourseMapper implements RowMapper<CourseObj> {

	public CourseObj mapRow(ResultSet arg0, int arg1) throws SQLException {
		CourseObj course = new CourseObj();
		course.setIdCourse(arg0.getInt("idCourse"));
		course.setNameCourse(arg0.getString("NameCourse"));
		course.setStartDay(arg0.getDate("StartDay"));
		course.setEndDay(arg0.getDate("EnddDay"));
		course.setNumbers(arg0.getInt("Numbers"));
		return course;
	}
	

}
