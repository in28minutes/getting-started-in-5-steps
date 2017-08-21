package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.repository.TransactionManagementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionManagementDemoApplicationTests {

	@Autowired
	TransactionManagementRepository transactionManagementRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void someTest() {
		
		try {
			transactionManagementRepository.doSomething();
		} catch (Exception e) { }
		
		assertNull(entityManager.find(Passport.class, 1L));
	}
}
