package Spring.tutorial.jdbcTemplate;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import Spring.tutorial.DAO.CourseDAO;
import Spring.tutorial.map.CourseMapper;
import Spring.tutorial.obj.CourseObj;

public class CourseJDBCTemplate implements CourseDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	
	public void setDataSource() {}

	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void createCourse(int id, String name, Date start, Date end, int number) {

		String sql = "insert into course(idCourse,NameCourse,StartDay,EndDay,Numbers) values (?,?,?,?,?)";
		jdbcTemplateObject.update(sql, id, name, start, end, number);
		return;
	}

	public CourseObj getCourse(int id) {
		String sql = "select * from course where idCourse= ?";
		CourseObj course = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new CourseMapper());
		return course;
	}

	public List<CourseObj> listCourse() {
		String sql = "select * from course";
		List<CourseObj> course = jdbcTemplateObject.query(sql, new CourseMapper());
		return course;
	}

	public void deleteCourse(int id) {
		
		String sql = "delete from course where idCourse = ?";
		jdbcTemplateObject.update(sql, id);
		return;
	}

	public void updateCourse(int id, String name, Date start, Date end, int number) {
		// TODO Auto-generated method stub
		String SQL = "update course set NameCourse = ?,StartDay = ? , EndDay = ?,Numbers = ? where idCourse = ?";
		jdbcTemplateObject.update(SQL, name, start, end, number, id);
		return;
	}

}
