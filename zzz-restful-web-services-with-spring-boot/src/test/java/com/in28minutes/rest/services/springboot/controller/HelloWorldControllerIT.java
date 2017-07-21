package com.in28minutes.rest.services.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.rest.services.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerIT {

	@Autowired
	private TestRestTemplate template;

	// @LocalServerPort - Not needed any more :)

	@Test
	public void helloWorld() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/hello-world"), String.class);
		assertThat(response.getBody(), equalTo("Hello World"));
	}

	private String createURL(String uri) {
		return uri;
	}

	@Test
	public void helloWorldWithBean() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/hello-world-bean"), String.class);
		assertThat(response.getBody(), containsString("Hello World"));
	}

	@Test
	public void helloWorldWithPathVariable() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/hello-world/path-variable/Buddy"),
				String.class);
		assertThat(response.getBody(), containsString("Hello World, Buddy"));
	}
}