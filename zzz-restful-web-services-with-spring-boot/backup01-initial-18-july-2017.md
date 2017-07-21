
## Complete Code Example


### /pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
     http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.in28minutes.rest.services</groupId>
	<artifactId>restful-services-in-20-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Restful Services with Spring Boot</name>
	<packaging>war</packaging>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.M1</version>
	</parent>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-hateoas</artifactId>
		</dependency>

 		<dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
        </dependency>
        
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.4.0</version>
		</dependency>
		
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.4.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>

</project>
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/Application.java

```java
package com.in28minutes.rest.services.springboot;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableCaching
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/bean/HelloWorldBean.java

```java
package com.in28minutes.rest.services.springboot.bean;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/bean/User.java

```java
package com.in28minutes.rest.services.springboot.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Size(min = 2, message = "Enter atleast 2 Characters.")
	private String name;

	private Date birthDate;

	public User() {

	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/controller/HelloWorldController.java

```java
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
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/controller/UserController.java

```java
package com.in28minutes.rest.services.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.services.springboot.bean.User;
import com.in28minutes.rest.services.springboot.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		}

		Resource<User> userResource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		userResource.add(linkTo.withRel("all-users"));
		return userResource;
	}

	@PostMapping("/users")
	ResponseEntity<?> add(@Valid @RequestBody User userToSave) {
		User user = userService.save(userToSave);
		if (user == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/controller/UserJPAController.java

```java
package com.in28minutes.rest.services.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.services.springboot.bean.User;
import com.in28minutes.rest.services.springboot.service.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userService;

	@ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
	@GetMapping("/jpa/users")
	public Page<User> retrieveAllUsers(Pageable pageRequest) {
		return userService.findAll(pageRequest);
	}

	@ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
	@GetMapping("/jpa/users-with-hateoas")
	public HttpEntity<PagedResources<User>> retrieveAllUsersWithHateoas(Pageable pageRequest,
			PagedResourcesAssembler assembler) {
		Page<User> users = userService.findAll(pageRequest);
		return new ResponseEntity<>(assembler.toResource(users), HttpStatus.OK);
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id, Pageable pageRequest) {
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		Resource<User> userResource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers(pageRequest));
		userResource.add(linkTo.withRel("all-users"));
		return userResource;
	}

	@PostMapping("/jpa/users")
	ResponseEntity<?> add(@Valid @RequestBody User userToSave) {
		User user = userService.save(userToSave);
		if (user == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/controller/UserNotFoundException.java

```java
package com.in28minutes.rest.services.springboot.controller;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 389949206272875015L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/exception/ExceptionResponse.java

```java
package com.in28minutes.rest.services.springboot.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp = new Date();
	private String message;
	private Object details;

	public ExceptionResponse(String message, Object details) {
		super();
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Object getDetails() {
		return details;
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/exception/RestResponseEntityExceptionHandler.java

```java
package com.in28minutes.rest.services.springboot.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.services.springboot.controller.UserNotFoundException;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> userNotFound(UserNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
				"Any details you would want to add");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getBindingResult());
		return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/filtering/FilteringController.java

```java
package com.in28minutes.rest.services.springboot.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "value3" })
class SomeBean {
	String value1;

	@JsonIgnore
	String value2;
	
	String value3;

	public SomeBean(String value1, String value2, String value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

}

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean uriV1() {
		return new SomeBean("value1", "value2", "value3");
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/service/UserDaoService.java

```java
package com.in28minutes.rest.services.springboot.service;

import java.util.List;

import com.in28minutes.rest.services.springboot.bean.User;

public interface UserDaoService {
	public List<User> findAll();

	public User save(User user);

	public User findOne(int id);
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/service/UserRepository.java

```java
package com.in28minutes.rest.services.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.services.springboot.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/service/UserService.java

```java
package com.in28minutes.rest.services.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.services.springboot.bean.User;

@Service
public class UserService implements UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 3;

	static {
		users.add(new User(1, "Alice", new Date()));
		users.add(new User(2, "Bob", new Date()));
		users.add(new User(3, "Charlie", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/SwaggerConfig.java

```java
package com.in28minutes.rest.services.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/versioning/Name.java

```java
package com.in28minutes.rest.services.springboot.versioning;

public class Name {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
```
---

### /src/main/java/com/in28minutes/rest/services/springboot/versioning/VersioningController.java

```java
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
```
---

### /src/main/resources/application.properties

```properties
spring.jackson.serialization.WRITE_DATES_AS_TIMESTAMPS = false
security.user.name=user
security.user.password=password
```
---

### /src/main/resources/messages.properties

```properties
helloWorld.message=Hello World in English
```
---

### /src/main/resources/messages_fr.properties

```properties
helloWorld.message=Hello World in French
```
---

### /src/test/java/com/in28minutes/rest/services/springboot/controller/HelloWorldControllerIT.java

```java
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
	
	//@LocalServerPort - Not needed any more :)

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
```
---

### /src/test/java/com/in28minutes/rest/services/springboot/controller/HelloWorldControllerTest.java

```java
package com.in28minutes.rest.services.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class, secure = false)
public class HelloWorldControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void helloWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void helloWorldWithBean() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello-world-bean").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
	}

	@Test
	public void helloWorldWithPathVariable() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello-world/path-variable/Buddy").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Hello World, Buddy")));
	}
}
```
---

### /src/test/java/com/in28minutes/rest/services/springboot/controller/UserControllerIT.java

```java
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
```
---

### /src/test/java/com/in28minutes/rest/services/springboot/controller/UserControllerTest.java

```java
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
```
---

### /src/test/resources/application.properties

```properties
#Disable this to enable basic security
spring.h2.console.enabled=true
security.basic.enabled=false
management.security.enabled=false
```
---

### /useful-files-not-used-in-code/basic_response.json

```json
[
  {
    "id": 1,
    "name": "Even",
    "birthDate": "2017-07-10T07:52:48.270+0000"
  },
  {
    "id": 2,
    "name": "Abe",
    "birthDate": "2017-07-10T07:52:48.270+0000"
  },
  {
    "id": 3,
    "name": "Bob",
    "birthDate": "2017-07-10T07:52:48.270+0000"
  },
  {
    "id": 4,
    "name": "Charlie",
    "birthDate": "2017-07-10T07:52:48.270+0000"
  }
]
```
---

### /useful-files-not-used-in-code/post_request_body_example.json

```json
{
  "name": "Even",
  "birthDate": "2017-07-10T07:52:48.270+0000"
}
```
---

### /useful-files-not-used-in-code/response_with_pagination.json

```json
{
  "content": [
    {
      "id": 8,
      "name": "Even",
      "birthDate": 149967316827
    },
    {
      "id": 7,
      "name": "Even",
      "birthDate": "2017-07-10T07:52:48.270+0000"
    },
    {
      "id": 6,
      "name": "Even",
      "birthDate": "2017-07-10T07:52:48.270+0000"
    },
    {
      "id": 5,
      "name": "Even",
      "birthDate": "2017-07-10T07:52:48.270+0000"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false
    },
    "offset": 4,
    "pageSize": 4,
    "pageNumber": 1,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 3,
  "totalElements": 12,
  "last": false,
  "size": 4,
  "number": 1,
  "numberOfElements": 4,
  "sort": {
    "sorted": true,
    "unsorted": false
  },
  "first": false
}
```
---

### /useful-files-not-used-in-code/response_with_pagination_and_hateoas.json

```json
{
  "_embedded": {
    "users": [
      {
        "name": "Even",
        "birthDate": "2017-07-10T07:52:48.270+0000"
      },
      {
        "name": "Even",
        "birthDate": "2017-07-10T07:52:48.270+0000"
      },
      {
        "name": "Even",
        "birthDate": "2017-07-10T07:52:48.270+0000"
      },
      {
        "name": "Even",
        "birthDate": "2017-07-10T07:52:48.270+0000"
      }
    ]
  },
  "_links": {
    "first": {
      "href": "http://localhost:8080/users-with-hateoas?page=0&size=4&sort=id,desc"
    },
    "prev": {
      "href": "http://localhost:8080/users-with-hateoas?page=0&size=4&sort=id,desc"
    },
    "self": {
      "href": "http://localhost:8080/users-with-hateoas?page=1&size=4&sort=id,desc"
    },
    "next": {
      "href": "http://localhost:8080/users-with-hateoas?page=2&size=4&sort=id,desc"
    },
    "last": {
      "href": "http://localhost:8080/users-with-hateoas?page=2&size=4&sort=id,desc"
    }
  },
  "page": {
    "size": 4,
    "totalElements": 12,
    "totalPages": 3,
    "number": 1
  }
}
```
---
