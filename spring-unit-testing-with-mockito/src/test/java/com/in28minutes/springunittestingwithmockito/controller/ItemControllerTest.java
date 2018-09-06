package com.in28minutes.springunittestingwithmockito.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
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

import com.in28minutes.springunittestingwithmockito.business.ItemService;
import com.in28minutes.springunittestingwithmockito.entity.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ItemService service;

	@Test
	public void retrieveItems() throws Exception {
		List<Item> mockList = Arrays.asList(new Item(1, "Dummy", 10, 5));
		when(service.calculateTotalValue()).thenReturn(mockList);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String expected = "[" + "{id:1,name:Dummy}" + "]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}