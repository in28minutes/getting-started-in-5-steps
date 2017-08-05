package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class SomeBusinessXMLTest {
	
	@Autowired
	private SomeBusiness business;

	@Test
	public void contextLoads() {
		int result = business.sum();
		assertEquals(21,result);
	}

}
