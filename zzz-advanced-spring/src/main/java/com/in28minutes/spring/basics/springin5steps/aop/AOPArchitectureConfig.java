package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AOPArchitectureConfig {
	
	//@Pointcut("within(com.in28minutes.spring.basics.springin5steps.aop.business..*)")
	//@Pointcut("businessService() && dataService()")
	@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.business.*.*(..))")
    public void businessService() {}

	@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.data.*.*(..))")
    public void dataService() {}

	@Pointcut("bean(*dao*)")
    public void daoServices() {}

	//@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.*.*.*(..))")
	@Pointcut("within(com.in28minutes.spring.basics.springin5steps.aop..*)")
	public void anyMethod() {}
	
	@Pointcut("@annotation(com.in28minutes.spring.basics.springin5steps.aop.business.TrackTime) ")
	public void trackTime() {}

}
