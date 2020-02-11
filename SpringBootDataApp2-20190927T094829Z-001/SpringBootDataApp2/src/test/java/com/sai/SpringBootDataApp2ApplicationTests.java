package com.sai;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sai.entities.Teacher;
import com.sai.repositories.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataApp2ApplicationTests {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	//@Ignore
	public void testInsertTeacher_Success() {
		    Teacher teacher=new Teacher();
		    teacher.setName("teacher5");
		    teacher.setSpecialization("spec7");
       		Teacher t1=teacherRepository.save(teacher);
       		assertTrue(t1 != null);
	}
	
	@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateTeacherSpecilization_shouldUpdate() {
		int count=teacherRepository.updateTeacherSpecialization(6,"spec10");
	    fetchTeacherList();
		assertTrue( count != 0);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Ignore
	public void testDeleteTeacher_BySpecialization() {
		int count = teacherRepository.deleteTeacherBySpecialization("spec1");
		assertTrue(count != 0);
	}
	
	
	private void fetchTeacherList() {
		Iterable<Teacher> teacherList=teacherRepository.findAll();
		teacherList.forEach(t1 -> {
			System.out.println(t1.getId()+", "+t1.getName()+", "+t1.getSpecialization());
		});
	}

}
