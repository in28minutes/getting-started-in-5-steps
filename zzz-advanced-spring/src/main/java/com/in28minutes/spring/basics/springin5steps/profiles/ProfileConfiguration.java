package com.in28minutes.spring.basics.springin5steps.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfiguration {
	@Bean
	@Profile("default")
	public Cacheable getDev() {
		return new NormalCache();
	}

	@Bean
	@Profile("prod")
	public Cacheable getProd() {
		return new DistributedCache();
	}
}
