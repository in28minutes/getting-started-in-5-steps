package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.binarysearch.SomeSearchImpl;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		// SortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		// SomeSearchImpl searchImpl = new SomeSearchImpl(sortAlgorithm);

		ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
		SomeSearchImpl searchImpl = context.getBean(SomeSearchImpl.class);

		searchImpl.binarySearch(new int[] { 1, 3, 2 }, 5);
	}
}