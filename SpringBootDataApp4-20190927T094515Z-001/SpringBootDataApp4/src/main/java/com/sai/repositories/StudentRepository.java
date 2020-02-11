package com.sai.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>{

	//@Query(value="")
	//Student fetchStudentDetailsByID(int studentID);
	
}
