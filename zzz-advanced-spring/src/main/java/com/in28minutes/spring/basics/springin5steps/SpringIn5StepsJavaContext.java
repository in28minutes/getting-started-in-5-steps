package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.cdi.SomeCDIBusiness;

@ComponentScan
@Configuration
public class SpringIn5StepsJavaContext {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsJavaContext.class)){
			System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

			int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);

			System.out.println(result);

			SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);

			int result2 = someCDIBusiness.sum();

			System.out.println(result2);
		};


	}
}