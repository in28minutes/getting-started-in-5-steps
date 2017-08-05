package com.in28minutes.spring.basics.springin5steps;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.jdbc.Person;
import com.in28minutes.spring.basics.springin5steps.jdbc.PersonSpringJdbcDao;

@SpringBootApplication
public class SpringIn5StepsJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsJdbcApplication.class, args);
	}

	@Autowired
	PersonSpringJdbcDao jdbcService;

	@Override
	public void run(String... args) throws Exception {

		jdbcService.insert(new Person(10001, "Ranga Karanam", "Hyderabad", new Date()));
		jdbcService.insert(new Person(10002, "Jack", "Charleston", new Date()));
		jdbcService.insert(new Person(10003, "Ravi", "Charleston", new Date()));
		jdbcService.insert(new Person(10004, "Satish", "Charleston", new Date()));
		jdbcService.insert(new Person(10005, "Jim", "Charleston", new Date()));

		jdbcService.update(new Person(10002, "Jack", "Greenville", new Date()));

		System.out.println(jdbcService.findById(10002));

		System.out.println(jdbcService.findAll());

		jdbcService.deleteById(10002);
		System.out.println("After deleting 10002");
		System.out.println(jdbcService.findAll());
	}
}
