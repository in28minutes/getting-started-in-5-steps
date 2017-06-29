package com.example.demo.binarysearch;

import org.springframework.stereotype.Component;

@Component
public class SomeSearchImpl {

	private SortAlgorithm sortAlgorithm;

	public SomeSearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int valueToSearchFor) {
		// Sort the values
		System.out.println(sortAlgorithm);

		int[] sortedNumbers = sortAlgorithm.sort(numbers);

		// Pick the right one

		// Return index
		return 5;
	}
}
