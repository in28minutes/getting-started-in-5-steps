package com.in28minutes.jpa.hibernate.app.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager entityManager;

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() != null) {
			entityManager.merge(student);
		} else {
			entityManager.persist(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}

	public void playWithStudent() {		
		Student student = new Student("Ranga", LocalDate.of(2000, Month.APRIL,10));
		entityManager.persist(student);
		entityManager.flush();
		// entityManager.remove(student);
		student.setName("Ranga-Changed");
		//entityManager.detach(student);
		entityManager.refresh(student);
		// entityManager.remove(student);
		// entityManager.merge(student);
		// Queries
		// Entity Graphs
	}
	
	public void transientFields() {		
		Student student = new Student("Ranga", LocalDate.of(2000, Month.APRIL,10));
		entityManager.persist(student);
		entityManager.flush();
		// entityManager.remove(student);
		student.setName("Ranga-Changed");
		//entityManager.detach(student);
		entityManager.refresh(student);
		// entityManager.remove(student);
		// entityManager.merge(student);
		// Queries
		// Entity Graphs
	}
}
