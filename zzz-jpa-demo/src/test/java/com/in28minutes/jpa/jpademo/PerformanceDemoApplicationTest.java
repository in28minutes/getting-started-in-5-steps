package com.in28minutes.jpa.jpademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformanceDemoApplicationTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void testNplus1(){
		courseRepository.printAllCourseAndStudents();
		//courseRepository.printAllCourseAndStudentsDynamicSubgraph();
		//courseRepository.printAllCourseAndStudentsJoinFetch();
	}


}
