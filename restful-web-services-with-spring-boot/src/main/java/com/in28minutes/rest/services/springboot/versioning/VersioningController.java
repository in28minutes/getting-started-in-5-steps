package com.in28minutes.rest.services.springboot.versioning;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

class PersonV1 {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}
}

class PersonV2 {
	Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}
}

@RestController
public class VersioningController {

	@GetMapping("/persons/uri/v1")
	public List<PersonV1> uriV1() {
		return Arrays.asList(new PersonV1("Bob Charlie"));
	}

	@GetMapping("/persons/uri/v2")
	public List<PersonV2> uriV2() {
		return Arrays.asList(new PersonV2(new Name("Bob", "Charlie")));
	}

	@GetMapping(value = "/persons/header", headers = "X-API-Version=v1")
	public List<PersonV1> headerV1() {
		return Arrays.asList(new PersonV1("Bob Charlie"));
	}

	@GetMapping(value = "/persons/header", headers = "X-API-Version=v2")
	public List<PersonV2> headerV2() {
		return Arrays.asList(new PersonV2(new Name("Bob", "Charlie")));
	}

	@GetMapping(value = "/persons/produces", produces = "application/vnd.company.app-v1+json")
	public List<PersonV1> producesV1() {
		return Arrays.asList(new PersonV1("Bob Charlie"));
	}

	@GetMapping(value = "/persons/produces", produces = "application/vnd.company.app-v2+json")
	public List<PersonV2> producesV2() {
		return Arrays.asList(new PersonV2(new Name("Bob", "Charlie")));
	}

}
