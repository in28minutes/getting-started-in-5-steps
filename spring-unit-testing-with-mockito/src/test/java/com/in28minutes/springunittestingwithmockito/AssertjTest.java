package com.in28minutes.springunittestingwithmockito;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertjTest {

	@Test
	public void basicHamcrestMatchers() {
		//List
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		
		assertThat(scores).hasSize(4);
		assertThat(scores).contains(100, 101);
		assertThat(scores).allMatch(x -> x > 90);
		assertThat(scores).allMatch(x -> x < 200);

		// String
		assertThat("").isEmpty();

		// Array
		Integer[] marks = { 1, 2, 3 };

		assertThat(marks).hasSize(3);
		assertThat(marks).contains(2, 3, 1);

	}
}