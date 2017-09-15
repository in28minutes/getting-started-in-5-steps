package com.in28minutes.jpa.hibernate.app.repository;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.entity.inheritance.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.app.entity.inheritance.PartTimeEmployee;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class InheritanceDemoApplicationTest {

  // @LocalServerPort
  // String port;

  @Autowired
  EntityManager entityManager;

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void basic() {
    employeeRepository.insertEmployee(new PartTimeEmployee("PartTimeEE", new BigDecimal(100)));
    employeeRepository.insertEmployee(new FullTimeEmployee("FullTimeEE", new BigDecimal(10)));
    System.out.println(employeeRepository.allEmployees());
  }
}