package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppApplication.class)
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	public void findById(){
		assertNotNull(repository.findById(10001L));
		assertNull(repository.findById(10004L));
	}
	
	@Test
	public void deleteById(){
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}
	
	@Test
	public void save(){
		Course course = repository.findById(10001L);
		course.setName("Name Changed");
		repository.save(course);
		Course courseUpdated = repository.findById(10001L);
		assertEquals("Name Changed",courseUpdated.getName());
	}

}
