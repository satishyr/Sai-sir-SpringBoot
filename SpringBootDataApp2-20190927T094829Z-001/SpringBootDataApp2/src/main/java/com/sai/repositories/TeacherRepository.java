package com.sai.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sai.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher,Integer>{

	@Modifying
	@Query(value="update teacher set specialization=?2 where id=?1",nativeQuery=true)
	int updateTeacherSpecialization(int id,String spec);
	
	
	@Modifying
	@Query(value="delete from teacher where specialization=:spec",nativeQuery=true)
	int deleteTeacherBySpecialization(@Param("spec") String t1);
}
