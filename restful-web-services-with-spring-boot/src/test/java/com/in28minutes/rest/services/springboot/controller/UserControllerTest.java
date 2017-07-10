package com.in28minutes.rest.services.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.rest.services.springboot.bean.User;
import com.in28minutes.rest.services.springboot.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;

	@Test
	public void retrieveUsers() throws Exception {
		List<User> mockList = Arrays.asList(new User(1, "Alice", new Date()), new User(2, "Bob", new Date()));
		when(service.findAll()).thenReturn(mockList);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String expected = "[" + "{id:1,name:Alice}" + "," + "{id:2,name:Bob}" + "]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void retrieveUser() throws Exception {
		User mockUser = new User(1, "Alice", new Date());
		when(service.findOne(anyInt())).thenReturn(mockUser);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String expected = "{id:1,name:Alice}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void createUser() throws Exception {
		User mockUser = new User(4, "Eve", new Date());
		String user = "{\"name\":\"Eve\"}";

		when(service.save(any(User.class))).thenReturn(mockUser);

		mvc.perform(MockMvcRequestBuilders.post("/users").content(user).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(header().string("location", containsString("/users/4")));
	}

	@Test
	public void createUser_withValidationError() throws Exception {
		User mockUser = new User(4, "A", new Date());
		String user = "{\"name\":\"A\"}";

		when(service.save(any(User.class))).thenReturn(mockUser);

		mvc.perform(
				MockMvcRequestBuilders.post("/users/Jack/todos").content(user).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andReturn();
	}
}