package com.in28minutes.rest.services.springboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.services.springboot.bean.HelloWorldBean;
import com.in28minutes.rest.services.springboot.bean.User;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldWithBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldWithPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s!", name));
	}

	@GetMapping("/hello-world/i18n")
	public String helloWorldInternationalized(
			@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("helloWorld.message", null, locale);
	}

	@GetMapping(path = "/hello-world/exception")
	public User errorService() {
		throw new RuntimeException("Some Exception Occured");
	}

}