package com.in28minutes.jpa.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@GetMapping("/courses/{id}")
	public  Course retrieveCourse(@PathVariable long id){
		return repository.retrieveCourse(id);
	}
}
