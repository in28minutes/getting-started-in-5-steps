package com.in28minutes.spring.basics.springin5steps.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public String retrieveSomeData() {
		return "Dao1";
	}

}
