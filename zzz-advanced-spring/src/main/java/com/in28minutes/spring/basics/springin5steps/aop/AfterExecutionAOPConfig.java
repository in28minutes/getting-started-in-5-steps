package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterExecutionAOPConfig {
	@After("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.anyMethod()")
	//@AfterReturning
	//@AfterThrowing
	public void after(JoinPoint joinPoint) {
		System.out.println("Clean up after " + joinPoint.getSignature().toString());
	}

}
