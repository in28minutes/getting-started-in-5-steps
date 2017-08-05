package com.in28minutes.spring.basics.springin5steps.basics;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
		return 3;
	}

	
	@PostConstruct
	public void postConstruct(){
		System.out.println("Post construct");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("Pre Destroy");
	}
}
