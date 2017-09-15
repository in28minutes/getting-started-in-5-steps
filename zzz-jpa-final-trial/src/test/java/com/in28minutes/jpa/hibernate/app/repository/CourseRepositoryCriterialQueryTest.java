package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class CourseRepositoryCriterialQueryTest {

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
	    Predicate condition = cb.like(course.get("name"), "%100 Steps");
	    cq.where(condition);

	    TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

	    List<Course> courses = query.getResultList();
	    System.out.println(courses);

	    assertEquals(2, courses.size());
	    System.out.println(courses);
	  }

}
