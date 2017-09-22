package vn.ifisolution.fresher12.Student_CourseCassandra;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.ifisolution.fresher12.Student_CourseCassandra.model.Student;
import vn.ifisolution.fresher12.Student_CourseCassandra.repository.StudentRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired
	StudentRepository studentRepository;
//    @Autowired
//    StudentSearch studentSearch;
	public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

	public void run(String... arg0) throws Exception {
		saveStudent();
		
	}
	public void saveStudent(){
		Student student = new Student(3,"tran", "khoa", 19);
		studentRepository.save(student);
		searchStudent();
	}
	public void searchStudent(){
//		System.out.println(studentSearch.findAll().hashCode());	
	}
}
