package com.sai;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.entities.LoginDetails;
import com.sai.repositories.LoginDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFlywayAppApplicationTests {
	
	@Autowired
	LoginDetailsRepository loginDetailsRepository;
	
	LoginDetails loginDetails;
	
	@Before
	public void setupLoginDetailsData() {
		loginDetails = new LoginDetails();
		loginDetails.setId(2);
		loginDetails.setUname("john");
		loginDetails.setUpass("john");
	}

	@Test
	@Ignore
	public void shouldInsertUserDetails_Success() {
		LoginDetails dbDetails=loginDetailsRepository.save(loginDetails);
		assertTrue(dbDetails != null);
	}
	
	@Test
	public void shouldFetchUsernameAndPassword_Success() {
		Optional<LoginDetails> optionalLoginDetails = loginDetailsRepository.findByUnameAndUpass("john","john");
		assertTrue(optionalLoginDetails.isPresent());
	}
}
