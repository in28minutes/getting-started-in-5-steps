package com.in28minutes.microservices.configexampleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limit retrieveLimits() {
		Limit limit = new Limit();
		limit.setMinimum(configuration.getMinimum());
		limit.setMaximum(configuration.getMaximum());
		return limit;
	}

}

class Limit {
	private int maximum;
	private int minimum;

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

}

@Component
@ConfigurationProperties("config")
class Configuration {
	private int minimum;
	private int maximum;

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
