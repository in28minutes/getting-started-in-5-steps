package com.in28minutes.spring.basics.springin5steps.profiles;

public class DistributedCache implements Cacheable {

	@Override
	public void doSomething() {
		System.out.println("Distributed Cache");
	}

}
