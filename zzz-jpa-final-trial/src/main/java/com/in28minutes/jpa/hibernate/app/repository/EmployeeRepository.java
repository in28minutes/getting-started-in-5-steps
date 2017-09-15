package com.in28minutes.jpa.hibernate.app.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.inheritance.Employee;

@Transactional
@Repository
public class EmployeeRepository {
  
  @Autowired
  EntityManager entityManager;
  
  public void insertEmployee(Employee employee) {
    entityManager.persist(employee);
  }
  
  public List<Employee> allEmployees() {
    return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
  }
  
  

}