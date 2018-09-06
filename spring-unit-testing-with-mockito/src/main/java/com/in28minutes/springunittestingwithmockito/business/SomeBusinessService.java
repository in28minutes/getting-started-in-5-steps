package com.in28minutes.springunittestingwithmockito.business;

import java.util.Arrays;

import com.in28minutes.springunittestingwithmockito.data.SomeDataService;

public class SomeBusinessService {

	private SomeDataService someData;

	public SomeBusinessService(SomeDataService someData) {
		super();
		this.someData = someData;
	}

	public int calculateSum() {
		return Arrays.stream(someData.retrieveData())
				.reduce(Integer::sum).orElse(0);
	}
}