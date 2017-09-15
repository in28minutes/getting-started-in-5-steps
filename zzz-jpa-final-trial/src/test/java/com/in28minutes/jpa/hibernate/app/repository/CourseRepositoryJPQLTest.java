package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class CourseRepositoryJPQLTest {

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
}
