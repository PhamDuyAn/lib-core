package fresher.SpringCassandra.Repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fresher.SpringCassandra.Obj.Course;
@Repository
public interface CourseRepository extends  CrudRepository<Course,String>{
	@Query(value="SELECT * FROM course")
	public List<Course> getCourse();
	
	@Query(value="SELECT * FROM customer WHERE id=?0")
	public List<Course> getbyIDCourse(int idCourse);	

}
