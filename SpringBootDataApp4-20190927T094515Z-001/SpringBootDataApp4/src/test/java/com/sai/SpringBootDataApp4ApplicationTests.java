package com.sai;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sai.entities.HallTicket;
import com.sai.entities.Student;
import com.sai.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBootDataApp4ApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Transactional
	@Rollback(false)
	@Ignore
	public void createStudentDetails_WithHallTicketDetails() {
		Student student=new Student();
		student.setName("john1");
		student.setBranch("CSE");
		HallTicket hallTicket=new HallTicket();
		hallTicket.setHallticketNumber("03D01A0522");
		student.setHallTicket(hallTicket);
		
		Student st=studentRepository.save(student);
		
		assertTrue( st != null);
	}
	
	@Test
	@Transactional(readOnly=true)
	public void fetchStudentDetails_withHallTicketDetails() {
		Optional<Student> optional=studentRepository.findById(8);
		if(optional.isPresent()) {
			Student student=optional.get();
			System.out.println("Student details..."+student.getName()+","+student.getBranch());
			
			HallTicket hallTicket = student.getHallTicket();
			Student mystudent = hallTicket.getStudent();
			System.out.println("Hallticket...."+student.getHallTicket());
			
			//HallTicket hallTicket = student.getHallTicket();
		    //System.out.println("Hallticket details..."+hallTicket.getHallticketNumber());
		}
	}

}
