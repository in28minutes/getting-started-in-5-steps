package com.example.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockTest {

	@Mock
	DataService dataServiceMock;

	@InjectMocks
	BusinessServiceImpl businessService;

	@Test
	public void testFindGreatest_withMock() {
		DataService dataServiceMock = mock(DataService.class);
		given(dataServiceMock.getData(5)).willReturn(new int[] { 4, 5, 6 });// when

		BusinessServiceImpl businessService = new BusinessServiceImpl(dataServiceMock);
		assertEquals(6, businessService.findGreatest(5));
	}

	@Test
	public void testFindGreatest_withMock_Refactored() {
		given(dataServiceMock.getData(5)).willReturn(new int[] { 4, 5, 6 });// when
		assertEquals(6, businessService.findGreatest(5));
	}

}