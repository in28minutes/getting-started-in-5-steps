package com.in28minutes.springunittestingwithmockito;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springunittestingwithmockito.business.ItemService;
import com.in28minutes.springunittestingwithmockito.data.ItemRepository;
import com.in28minutes.springunittestingwithmockito.entity.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringUnitTestingWithMockitoApplicationTests {
	
	@MockBean
	ItemRepository repository;
	
	@Autowired
	ItemService service;

	@Test
	public void contextLoads() {
		List<Item> asList = new ArrayList<Item>();
		asList.add(new Item(1, "Dummy", 10, 5));
		
		when(repository.findAll()).thenReturn(asList);

		System.out.println(service.calculateTotalValue());
	}

}
