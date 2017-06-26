package com.example.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusinessServiceStubTest {

	@Test
	public void testFindGreatest_withStubs() {
		DataService dataServiceStub = new DataServiceStub();
		BusinessServiceImpl businessService = new BusinessServiceImpl(dataServiceStub);
		assertEquals(9, businessService.findGreatest(5));
	}
}

class DataServiceStub implements DataService {
	@Override
	public int[] getData(int id) {
		return new int[] { 3, 6, 9 };
	}

}