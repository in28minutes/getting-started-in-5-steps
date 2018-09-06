package com.in28minutes.springunittestingwithmockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springunittestingwithmockito.business.ItemService;
import com.in28minutes.springunittestingwithmockito.entity.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping("/items")
	public List<Item> retrieveAllItems() {
		return service.calculateTotalValue();
	}

}
