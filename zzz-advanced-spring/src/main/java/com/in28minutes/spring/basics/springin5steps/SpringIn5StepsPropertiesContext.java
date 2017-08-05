package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.in28minutes.spring.basics.springin5steps.properties.SomeExternalService;

@ComponentScan
@Configuration
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesContext {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsPropertiesContext.class)) {
			System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

			SomeExternalService someBean = applicationContext.getBean(SomeExternalService.class);
			someBean.callService();
		}
		;

	}
}