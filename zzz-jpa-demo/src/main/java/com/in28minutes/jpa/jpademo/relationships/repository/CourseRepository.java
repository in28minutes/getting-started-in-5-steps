package com.in28minutes.jpa.jpademo.relationships.repository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Course_;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public void createCourse(Course course) {
		entityManager.persist(course);
	}

	public Course retrieveCourse(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void printAllCourseAndStudents() {
		EntityGraph graph = entityManager.getEntityGraph("graph.CourseAndStudents");
		List<Course> courses = entityManager.createQuery("Select c from Course c", Course.class)
				.setHint("javax.persistence.loadgraph", graph).getResultList();
		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void printAllCourseAndStudentsDynamicSubgraph() {
		EntityGraph<Course> graph = entityManager.createEntityGraph(Course.class);
		Subgraph<List<Student>> bookSubGraph = graph.addSubgraph(Course_.students);

		List<Course> courses = entityManager.createQuery("Select c from Course c", Course.class)
				.setHint("javax.persistence.loadgraph", graph).getResultList();

		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void printAllCourseAndStudentsJoinFetch() {
		List<Course> courses = entityManager.createQuery("Select c from Course c JOIN FETCH c.students s", Course.class)
				.getResultList();
		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void updateCourse(Course course) {
		entityManager.merge(course);
	}

	public void createCourseWithStudents(Course course, Student... students) {

		for (Student student : students) {
			course.addStudent(student);
			student.addCourse(course);
			if (student.getId() == null) {
				entityManager.persist(student);
			}
		}

		createCourse(course);

	}

	public void createReviewsForCourse(Course course, Review... reviews) {
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			if (review.getId() == null) {
				entityManager.persist(review);
			}
		}
	}

}
