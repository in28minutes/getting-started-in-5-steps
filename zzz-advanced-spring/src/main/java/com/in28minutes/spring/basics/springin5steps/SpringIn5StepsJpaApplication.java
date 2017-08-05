package com.in28minutes.spring.basics.springin5steps;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.jdbc.Person;
import com.in28minutes.spring.basics.springin5steps.jdbc.PersonJpaRepository;

@SpringBootApplication
public class SpringIn5StepsJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsJpaApplication.class, args);
	}

	@Autowired
	PersonJpaRepository jpaService;

	@Override
	public void run(String... args) throws Exception {

		jpaService.insert(new Person("Ranga Karanam", "Hyderabad", new Date()));
		jpaService.insert(new Person("Jack", "Charleston", new Date()));
		jpaService.insert(new Person("Ravi", "Charleston", new Date()));
		jpaService.insert(new Person("Satish", "Charleston", new Date()));
		jpaService.insert(new Person("Jim", "Charleston", new Date()));

		jpaService.update(new Person(2, "Jack", "Greenville", new Date()));

		System.out.println(jpaService.findById(2));

		System.out.println(jpaService.findAll());

		jpaService.deleteById(2);
		System.out.println("After deleting 2");
		System.out.println(jpaService.findAll());
	}
}
