
## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.example</groupId>
	<artifactId>jpa-in-10-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>jpa-with-in-memory-db-in-10-steps</name>
	<description>Demo project for in memory database H2</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
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

### /src/main/java/com/example/h2/H2InMemoryDbDemoApplication.java

```java
package com.example.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2InMemoryDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2InMemoryDbDemoApplication.class, args);
	}
}
```
---

### /src/main/java/com/example/h2/user/User.java

```java
package com.example.h2.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(query = "select u from User u", name = "query_find_all_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;// Not perfect!! Should be a proper object!
	private String role;// Not perfect!! An enum should be a better choice!

	protected User() {
	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}

}
```
---

### /src/main/java/com/example/h2/user/UserRepository.java

```java
package com.example.h2.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```
---

### /src/main/java/com/example/h2/user/UserService.java

```java
package com.example.h2.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}

	public User find(long id) {
		return entityManager.find(User.class, id);
	}
	
	public List<User> findAll() {
		Query query = entityManager.createNamedQuery(
				"query_find_all_users", User.class);
		return query.getResultList();
	}
}
```
---

### /src/main/java/com/example/h2/UserEntityManagerCommandLineRunner.java

```java
package com.example.h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.h2.user.User;
import com.example.h2.user.UserService;

@Component
public class UserEntityManagerCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserEntityManagerCommandLineRunner.class);
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) {

		log.info("-------------------------------");
		log.info("Adding Tom as Admin");
		log.info("-------------------------------");
		User tom = new User("Tom", "Admin");
		userService.insert(tom);
		log.info("Inserted Tom" + tom);

		log.info("-------------------------------");
		log.info("Finding user with id 1");
		log.info("-------------------------------");
		User user = userService.find(1L);
		log.info(user.toString());

		log.info("-------------------------------");
		log.info("Finding all users");
		log.info("-------------------------------");
		log.info(userService.findAll().toString());
	}
}
```
---

### /src/main/java/com/example/h2/UserRepositoryCommandLineRunner.java

```java
package com.example.h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.h2.user.User;
import com.example.h2.user.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) {
		User harry = new User("Harry", "Admin");
		userRepository.save(harry);
		log.info("-------------------------------");
		log.info("Finding all users");
		log.info("-------------------------------");
		for (User user : userRepository.findAll()) {
			log.info(user.toString());
		}
	}

}
```
---

### /src/main/resources/application.properties

```properties
spring.h2.console.enabled=true
#logging.level.org.hibernate=debug
spring.jpa.show-sql=true
```
---

### /src/main/resources/data.sql

```
insert into user (id, name, role) values (101, 'Ranga', 'Admin');
insert into user (id, name, role) values (102, 'Ravi', 'User');
insert into user (id, name, role) values (103, 'Satish', 'Admin');
```
---

### /src/test/java/com/example/h2/H2InMemoryDbDemoApplicationTests.java

```java
package com.example.h2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2InMemoryDbDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /src/test/java/com/example/h2/user/UserRepositoryTest.java

```java
package com.example.h2.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.h2.user.UserRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void check_todo_count() {
		assertEquals(3, userRepository.count());
	}
}
```
---
