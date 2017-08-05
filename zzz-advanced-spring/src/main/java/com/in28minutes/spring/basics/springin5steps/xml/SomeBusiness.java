package com.in28minutes.spring.basics.springin5steps.xml;

public class SomeBusiness {
	private SomeDAO someDao;

	public SomeBusiness() {
		super();
	}

	public SomeBusiness(SomeDAO someDao) {
		super();
		this.someDao = someDao;
	}

	public void setSomeDao(SomeDAO someDao) {
		this.someDao = someDao;
	}

	public int sum() {
		int[] data = someDao.getData();
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}
