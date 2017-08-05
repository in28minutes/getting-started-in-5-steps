package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Named;

@Named
public class SomeCDIDAO {
	public int[] getData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}