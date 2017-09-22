package Spring.tutorial.jdbcTemplate;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import Spring.tutorial.DAO.StudentDAO;
import Spring.tutorial.map.StudentMapper;
import Spring.tutorial.obj.StudentObj;

public class StudenJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource ds) {// public void setDataSource(DataSource ds);

		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void createStudent(int id, String name, Date date, String sex, String address) {
		String sql = "insert into students(idStudents,NameStudents,DateStudents,Sex,AddressStudents) values (?,?,?,?,?)";
		jdbcTemplateObject.update(sql, id, name, date, sex, address);
		return;
	}

	public StudentObj getStudent(int id) {

		String sql = "select * from students where idStudents = ?";
		StudentObj student = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new StudentMapper());
		//System.out.println(sql);
		return student;
	}

	public List<StudentObj> listStudents() {
		String sql = "select * from students";
		List<StudentObj> student = jdbcTemplateObject.query(sql, new StudentMapper());

		return student;
	}

	public void updateStudent(int id, String name, Date date, String sex, String address) {

		String sql = "update students set NameStudents = ?,DateStudents = ? , Sex = ?,AddressStudents = ? where idStudents = ?";
		jdbcTemplateObject.update(sql, name, date, sex, address, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	public void deleteStudent(int id) {

		String sql = "delete from students where idStudents = ?";
		jdbcTemplateObject.update(sql, id);
		return;
	}

}
