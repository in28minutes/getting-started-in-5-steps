package com.in28minutes.spring.basics.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
	
	@Value("${service.url}")
	private String service;
	
	public void callService(){
		System.out.println(service);
	}
	

}
