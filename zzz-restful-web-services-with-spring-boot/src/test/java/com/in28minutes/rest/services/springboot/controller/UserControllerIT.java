package com.in28minutes.rest.services.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.rest.services.springboot.Application;
import com.in28minutes.rest.services.springboot.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {

	@Autowired
	private TestRestTemplate template;

	HttpHeaders headers = createHeaders("user-name", "user-password");

	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			private static final long serialVersionUID = 4473026732652216248L;

			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	@Test
	public void retrieveUsers() throws Exception {
		String expected = "[" + "{id:1,name:Alice}" + "," + "{id:2,name:Bob}" + "," + "{id:3,name:Charlie}" + "]";

		ResponseEntity<String> response = template.exchange("/users", HttpMethod.GET,
				new HttpEntity<String>(null, headers), String.class);

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void retrieveUser() throws Exception {
		String expected = "{name:Alice}";

		ResponseEntity<String> response = template.getForEntity("/users/1", String.class);
		System.out.println(response.getBody());
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void addUser() throws Exception {
		User user = new User(null, "Eve", new Date());
		URI location = template.postForLocation("/users", user);
		assertThat(location.getPath(), containsString("/users/4"));
	}
}