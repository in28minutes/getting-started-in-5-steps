package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogExecutionTimeAOPConfig {
	@Around("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.trackTime()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		System.out.println("Time taken by " + joinPoint.getSignature().toString() + " is "
				+ (System.currentTimeMillis() - startTime));
		return proceed;
	}
}
