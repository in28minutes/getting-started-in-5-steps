package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsJavaContext;
import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsJavaContext.class)
public class SomeBusinessJavaTest {

	@Autowired
	private BinarySearchImpl search;

	@Test
	public void contextLoads() {
		int result = search.binarySearch(new int[] {}, 5);
		assertEquals(3, result);
	}

}
