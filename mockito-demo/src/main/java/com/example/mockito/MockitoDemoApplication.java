package com.example.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MockitoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoDemoApplication.class, args);
	}
}

@Component
class BusinessServiceImpl {

	@Autowired
	DataService dataService;

	public BusinessServiceImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	int findGreatest(int id) {
		int[] data = dataService.getData(id);
		int greatest = Integer.MIN_VALUE;
		for (int value : data) {
			if (value > greatest)
				greatest = value;
		}
		return greatest;
	}

}

interface DataService {
	public int[] getData(int id);
}
