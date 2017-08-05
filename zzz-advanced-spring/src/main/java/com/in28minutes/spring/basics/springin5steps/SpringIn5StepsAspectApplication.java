package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.aop.business.Business1;
import com.in28minutes.spring.basics.springin5steps.aop.business.Business2;

@SpringBootApplication
public class SpringIn5StepsAspectApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsAspectApplication.class, args);
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		Business1 business1 = applicationContext.getBean(Business1.class);
		Business2 business2 = applicationContext.getBean(Business2.class);
		System.out.println(business1.getSomething());
		System.out.println(business2.getSomething());
	}
}