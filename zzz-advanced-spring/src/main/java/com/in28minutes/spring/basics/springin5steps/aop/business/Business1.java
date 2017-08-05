package com.in28minutes.spring.basics.springin5steps.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.spring.basics.springin5steps.aop.data.Dao1;

@Service
public class Business1 {
	@Autowired
	private Dao1 dao;
	
	@TrackTime
	public String getSomething(){
		return dao.retrieveSomeData();
	}
}

