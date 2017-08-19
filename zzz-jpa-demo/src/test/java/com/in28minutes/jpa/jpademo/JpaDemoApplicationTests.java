package com.in28minutes.jpa.jpademo;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.ReviewRating;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;
import com.in28minutes.jpa.jpademo.relationships.entity.StudentType;
import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;
import com.in28minutes.jpa.jpademo.relationships.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class JpaDemoApplicationTests {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Test
	public void createCourseWithStudents() {
		Student student = new Student("Ranga", StudentType.FullTime);
		courseRepository.createCourseWithStudents(new Course("Spring in 100 Steps"), student);
		courseRepository.createCourseWithStudents(new Course("Spring Boot in 100 Steps"), student);
	}

	@Test
	public void createReviewsForCourse() {
		Course course = new Course("JPA in 100 Steps");
		courseRepository.createCourse(course);
		courseRepository.createReviewsForCourse(course, new Review(ReviewRating.FIVE, "Awesome Course"),
				new Review(ReviewRating.FIVE, "Wow!"));
		
	}

	@Test
	public void createCourse() {
		courseRepository.createCourse(new Course("JPA in 100 Steps"));
	}

	@Test
	@Transactional
	public void createStudentWithPassport() {
		Student student = new Student("Ranga", StudentType.FullTime);
		Passport passport = new Passport("A12345678");
		studentRepository.createStudentWithPassport(student, passport);
	}

	@Test
	public void updateCourse() {
		Course course = courseRepository.retrieveCourse(10001L);
		course.setName("JPA in 100 Steps - updated");
		course.setActiveFrom(LocalDate.of(2018, Month.APRIL, 10));
		courseRepository.updateCourse(course);
	}

	@After
	public void printAllData() {
		System.out.println("Dummy");
	}
}
