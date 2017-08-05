package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.xml.SomeBusiness;

public class SpringIn5StepsXMLContext {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

		SomeBusiness someBusiness = applicationContext.getBean(SomeBusiness.class);

		int result = someBusiness.sum();

		System.out.println(result);
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result2 = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);

		System.out.println(result2);
		
		applicationContext.close();
		
		System.out.println("Context Closed");

	}
}