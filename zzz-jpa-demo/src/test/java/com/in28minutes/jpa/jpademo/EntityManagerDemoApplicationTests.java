package com.in28minutes.jpa.jpademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.repository.EntityManagerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class EntityManagerDemoApplicationTests {

	@Autowired
	EntityManagerRepository entityManagerRepository;

	@Test
	public void someTest() {
		entityManagerRepository.doSomething();
	}
}
