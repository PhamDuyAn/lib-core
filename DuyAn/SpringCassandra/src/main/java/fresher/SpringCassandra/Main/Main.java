package fresher.SpringCassandra.Main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fresher.SpringCassandra.Obj.Course;
import fresher.SpringCassandra.Repository.CourseRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{
	
	@Autowired
    CourseRepository courseRepository;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Main.class, args);

	}

	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		//clearData();
		try {
		addCourse();
		}
		catch (Exception e) {
			System.out.println("-----------------------");
			// TODO: handle exception
		}
//		lookup();
	}
	public void addCourse()
	{
		System.out.println("---------------Save Course to Cassandra-----------------");
		Course cour1= new Course(10,"Java","2017-9-9","2017-11-11",10);
		courseRepository.save(cour1);
	}
	public void clearData(){
		courseRepository.deleteAll();
	}
	
	
	
	public void getCourse(){
		System.out.println("----------------get Course from Cassandra by--------------");
		List<Course> cour = courseRepository.getCourse();
		cour.forEach(System.out::println);
 
		System.out.println("-----------------get Course from Cassandra by id------------");
		List<Course> cours = courseRepository.getbyIDCourse(2);
		cours.forEach(System.out::println);
	}

}
