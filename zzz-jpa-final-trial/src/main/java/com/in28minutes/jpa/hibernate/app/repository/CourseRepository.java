package com.in28minutes.jpa.hibernate.app.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() != null) {
			entityManager.merge(course);
		} else {
			entityManager.persist(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}
}
