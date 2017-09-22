package Spring.tutorial.DAO;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import Spring.tutorial.obj.CourseObj;

public interface CourseDAO {
	public void setDataSource(DataSource ds);

	public void createCourse(int id, String name, Date start, Date end, int number);

	public CourseObj getCourse(int id);

	public List<CourseObj> listCourse();

	public void deleteCourse(int id);

	public void updateCourse(int id, String name, Date start, Date end, int number);
}
