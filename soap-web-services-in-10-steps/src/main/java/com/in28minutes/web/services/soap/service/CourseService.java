package com.in28minutes.web.services.soap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.web.services.soap.model.Course;

@Component
public class CourseService {
	private static List<Course> courses = new ArrayList<>();

	static {
		// Initialize Data
		Course course1 = new Course("Course1", "Spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));
		Course course4 = new Course("Course4", "Maven", "Most popular maven course on internet!",
				Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}
	
	public Course retrieveCourse(String courseId) {
		for (Course course : courses) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}
		return null;
	}
}