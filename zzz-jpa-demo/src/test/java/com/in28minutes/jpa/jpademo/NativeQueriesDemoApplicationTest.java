package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class NativeQueriesDemoApplicationTest {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Test
	public void basic() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c");
		System.out.println(query.getResultList());
	}

	@Test
	public void basic_with_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c where c.id = ?");
		query.setParameter(1	, 10001L);
		
		List resultList = query.getResultList();
		assertEquals(1,resultList.size());

		System.out.println(resultList);
	}

	@Test
	public void basic_with_named_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c where c.id = :id");
		query.setParameter("id", 10001L);
		
		List resultList = query.getResultList();
		assertEquals(1,resultList.size());

		System.out.println(resultList);
	}
	
	@Test
	public void basic_with_named_native_query() {
	}

	@Test
	@Transactional
	public void updating_a_number_of_rows() {
		Query query = entityManager.createNativeQuery("Update Course Set create_date_time=sysdate()");
		int executeUpdate = query.executeUpdate();
		System.out.println(executeUpdate);
	}
}
