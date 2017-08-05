package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {
	@Inject
	private SomeCDIDAO someDao;

	public SomeCDIBusiness() {
		super();
	}

	public SomeCDIBusiness(SomeCDIDAO someDao) {
		super();
		this.someDao = someDao;
	}

	public void setSomeDao(SomeCDIDAO someDao) {
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
