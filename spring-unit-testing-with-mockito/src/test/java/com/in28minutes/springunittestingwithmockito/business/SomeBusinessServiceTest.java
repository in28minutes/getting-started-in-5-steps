package com.in28minutes.springunittestingwithmockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.springunittestingwithmockito.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessServiceTest {
	
	@Mock
	SomeDataService dataService;
	
	@InjectMocks
	SomeBusinessService businessService;
	
	@Test(expected=Exception.class)
	public void testWithExpectedException() {	
		SomeDataService dataService = new SomeDataService();
		SomeBusinessService businessService = 
				new SomeBusinessService(dataService);
		businessService.calculateSum();
	}
	
	@Test
	public void testWithMock() {	
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.retrieveData()).thenReturn(new int[] {10,20});
		SomeBusinessService businessService = 
				new SomeBusinessService(dataService);
		assertEquals(30,businessService.calculateSum());
	}

	@Test
	public void playWithListClass() {
		
	}
	
	@Test
	public void testWithMock_usingMockitoRunner() {	
		when(dataService.retrieveData()).thenReturn(new int[] {10,20});
		assertEquals(30,businessService.calculateSum());
	}
	
	@Test
	public void mockitoRunnerUnderstandSpringAutowiringToo() {
		
	}
}
