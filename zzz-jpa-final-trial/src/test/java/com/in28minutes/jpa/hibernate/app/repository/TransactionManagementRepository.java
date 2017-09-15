package com.in28minutes.jpa.hibernate.app.repository;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;

@Repository
@Transactional
public class TransactionManagementRepository {

  @Autowired
  EntityManager entityManager;

  public void doSomething() {
    Passport passport1 = new Passport("E123456");
    entityManager.persist(passport1);
    Passport passport2 = new Passport(null);
    entityManager.persist(passport2);
  }
}