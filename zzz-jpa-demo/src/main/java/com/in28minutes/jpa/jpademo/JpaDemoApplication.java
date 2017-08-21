package com.in28minutes.jpa.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.jpademo.inheritence.repository.EmployeeRepository;
import com.in28minutes.jpa.jpademo.relationships.repository.StudentRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}