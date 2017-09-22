package com.cassandra.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cassandra.Entities.*;
@Repository("studentRepository")
public interface StudentRepository extends CrudRepository< Student , String>{
	

}
