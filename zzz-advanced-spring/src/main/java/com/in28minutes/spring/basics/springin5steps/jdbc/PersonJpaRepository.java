package com.in28minutes.spring.basics.springin5steps.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Person> findAll() {
		Query query = entityManager.createNamedQuery("find_all_persons_query", Person.class);
		return query.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void insert(Person person) {
		entityManager.merge(person);
	}

	public void update(Person person) {
		entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}