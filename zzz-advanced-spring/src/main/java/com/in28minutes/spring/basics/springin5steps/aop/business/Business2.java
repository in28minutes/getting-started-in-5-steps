package com.in28minutes.spring.basics.springin5steps.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.spring.basics.springin5steps.aop.data.Dao2;

@Service
public class Business2 {
	
	@Autowired
	private Dao2 dao;
	
	public String getSomething(){
		return dao.retrieveSomeData();
	}
}

