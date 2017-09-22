package Spring.tutorial.DAO;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import Spring.tutorial.obj.StudentObj;

public interface StudentDAO {

	public void setDataSource(DataSource ds);

	public void createStudent(int id, String name, Date date,String sex,String address);

	public StudentObj getStudent(int id);

	public List<StudentObj> listStudents();

	public void deleteStudent(int id);

	public void updateStudent(int id, String name,Date date,String sex,String address);

}
