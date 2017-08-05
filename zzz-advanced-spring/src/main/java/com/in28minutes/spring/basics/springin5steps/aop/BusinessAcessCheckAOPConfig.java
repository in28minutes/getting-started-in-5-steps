package com.in28minutes.spring.basics.springin5steps.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BusinessAcessCheckAOPConfig {
	@Before("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.businessService()")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before ");
		System.out.println(joinPoint.getSignature().toString() + " called with ");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		System.out.println("I Will check if the user has the right access");
	}
}
