package com.in28minutes.jpa.jpademo.relationships.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager entityManager;

	public void createStudentWithPassport(Student student, Passport passport) {
		student.setPassport(passport);
		//passport.setStudent(student);
		entityManager.persist(passport);
		entityManager.persist(student);
				
	}
}
