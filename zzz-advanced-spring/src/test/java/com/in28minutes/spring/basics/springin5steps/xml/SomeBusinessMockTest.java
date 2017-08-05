package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	private SomeBusiness business;

	@Mock
	private SomeDAO dao;

	@Test
	public void contextLoads() {
		Mockito.when(dao.getData()).thenReturn(new int[] { 1, 2, 3 });
		int result = business.sum();
		assertEquals(6, result);
	}

}
