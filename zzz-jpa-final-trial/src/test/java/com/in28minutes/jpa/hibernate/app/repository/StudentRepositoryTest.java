package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppApplication.class)
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository repository;
	
	@Test
	public void playWithStudent(){
		repository.playWithStudent();
	}

}
