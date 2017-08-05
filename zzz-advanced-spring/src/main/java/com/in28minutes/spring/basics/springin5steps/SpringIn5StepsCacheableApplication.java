package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.profiles.Cacheable;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;

@SpringBootApplication
public class SpringIn5StepsCacheableApplication {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCacheableApplication.class, args);
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
		PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		System.out.println(personDAO1);
		System.out.println(personDAO2);
		System.out.println(personDAO1.getConnection());
		System.out.println(personDAO2.getConnection());
		
		Cacheable cache = applicationContext.getBean(Cacheable.class);
		cache.doSomething();
		
	}
}