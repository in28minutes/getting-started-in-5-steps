package com.in28minutes.jpa.jpademo.relationships.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;

@Repository
@Transactional
public class EntityManagerRepository {

	@Autowired
	EntityManager entityManager;

	public void doSomething() {
		Passport passport = new Passport("E123456");
		entityManager.persist(passport);
		entityManager.flush();
		passport.setNumber("E123457");
		// entityManager.clear();
		// entityManager.detach(passport);
		// entityManager.refresh(passport);
		// entityManager.remove(passport);
		// entityManager.merge(passport);
		// Queries
		// Entity Graphs
	}
}
