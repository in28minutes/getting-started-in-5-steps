package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class JPQLDemoApplicationTest {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Test
	public void basic() {
		Query query = entityManager.createQuery("SELECT c FROM Course c");
		System.out.println(query.getResultList());
	}

	@Test
	public void basic_typed() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> resultList = query.getResultList();
		System.out.println(resultList);
	}

	@Test
	public void basic2() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE c.name like '%100 Steps'");
		List resultList = query.getResultList();
		assertEquals(2, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_empty_courses() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE c.students IS EMPTY");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_with_min_three_students() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE size(c.students) >= 3");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_order_by() {
		Query query = entityManager.createQuery("SELECT c FROM Course c ORDER BY size(c.students) DESC");
		List resultList = query.getResultList();
		assertEquals(3, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic3() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic4() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	// BETWEEN 100 and 1000
	// IS NULL
	// upper, lower, trim, length
	// Group by, having
	
	
	@Test
	public void join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c JOIN c.students s");
		List resultList = query.getResultList();
		System.out.println(resultList.get(1).getClass());
		assertEquals(5, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void left_outer_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		assertEquals(6, resultList.size());
		for (Object[] result : resultList) {
			Course course = (Course) result[0];
			Student student = (Student) result[1];
			System.out.println(course + " " + student);
		}
	}

	@Test
	public void cross_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c, Student s");
		List resultList = query.getResultList();
		assertEquals(12, resultList.size());
		System.out.println(resultList);
	}

}
