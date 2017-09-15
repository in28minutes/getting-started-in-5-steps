package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Course_;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class CriteriaQueryDemoApplicationTest {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Test
	public void basic() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> root = cq.from(Course.class);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(root));

		List<Course> courses = query.getResultList();
		System.out.println(courses);
	}

	@Test
	public void basic2() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> course = cq.from(Course.class);
		Predicate condition = cb.like(course.get(Course_.name), "%100 Steps");
		cq.where(condition);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

		assertEquals(2, courses.size());
		System.out.println(courses);
	}

	@Test
	public void basic_empty_courses() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> course = cq.from(Course.class);
		Predicate condition = cb.isEmpty(course.get(Course_.students));
		cq.where(condition);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

		assertEquals(1, courses.size());
		System.out.println(courses);
	}

	@Test
	public void basic_courses_order_by() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		cq.orderBy(cb.desc(course.get(Course_.name)));
		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

	}

	@Test
	public void join() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		Join<Course, Student> student = course.join(Course_.students);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);
		assertEquals(5, courses.size());
	}

	@Test
	public void left_outer_join() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		Join<Course, Student> student = course.join(Course_.students, JoinType.LEFT);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);
		assertEquals(6, courses.size());
	}
}