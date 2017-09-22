package com.cassandra.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.cassandra.Entities.Course;
import com.cassandra.repository.CourseRepository;


@SpringBootApplication
@ComponentScan("com.cassandra")
public class Controller implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}
    
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		InsertCourse();
		
	}
	
	public void InsertCourse() {
		Course course = new Course(2, "Java", "Fresher");
		courseRepository.save(course);
		
	}
	
	
      
	
}
