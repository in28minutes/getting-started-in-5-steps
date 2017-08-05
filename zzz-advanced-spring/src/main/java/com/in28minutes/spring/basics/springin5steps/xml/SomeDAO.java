package com.in28minutes.spring.basics.springin5steps.xml;

import javax.inject.Named;

@Named
public class SomeDAO {
	public int[] getData() {
		return new int[] { 1, 2, 3, 4, 5, 6 };
	}
}