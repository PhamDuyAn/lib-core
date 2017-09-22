package com.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cassandra.Entities.Course;
public interface CourseRepository extends CrudRepository<Course, String>{
	@Query("SELECT * FROM course where Course_Title = ?0")
	public List<Course> findBycourse_Title(String Course_Title);	

                  
}
