
## Complete Code Example


### /notes.txt

```
# What is a Web Service?

> Service delivered over the web

Is this really a complete definition. Is everything thats delivered over the web "Web Service"?

Let's consider a web application we developed for our Spring MVC Course to manage todo's.  (Web_Services_Web_Application_To_Manage_Todos)

Is this application a web service?

Nope. The answer is no. This is a web application. Not a web service.

We are back to square one.

- What is a web service?
- How is it differnent from a web application?

To understand this, lets consider an example.

Mark Zuckerberg likes my web application to manage todo's. He thinks that my todo application is a right fit to integrate into facebook to manage todo's. Can we use the existing application to do the integration? No.

Why? Because the existing application is designed for humans - other individuals. The output of the application is html which is rendered by browser to the end user. This is not designed for other applications.

What would be the difference in my thinking if I want to design the todo application so that other applications can interact with it?

I would need to produce the output in the format that the consumers can understand. Then facebook can call my web service and integrate it.

That leads use to - W3C definition of a Web Service
> Software system designed to support interoperable machine-to-machine interaction over a network.

The key things to understand is 
- Web services are designed for machine-to-machine (or application-to-application) interaction
- Web services should be interoperable - Not platform dependent
- Web services should allow communication over a network

## Types of Web Services

Facebook wants to talk to Todo Application. 
- Facebook is built on a variety of languages - PHP is used for the front-end, Erlang is used for Chat, Java and C++ are also used. 
- Todo Application is build on Java using Spring MVC

This is how we see the basic interaction
Web_Service_Basic_Interaction

Both applications should be able to understand the request and response. So, what formats should we use for the request and response?

They should be standard formats so that they can be used with varied kind of platforms. 
 - JSON and XML are quite popular Data Exchange formats.

Not really types but a broad classification
- SOAP
- REST

These are not really mutually exclusive. Some SOAP services can actually be RESTful. 

When does a web service become a SOAP Web service or a Restful web service?

### SOAP

SOAP was earlier an abbreviation for Simple Object Access Protocol. In SOAP, the request and response are in XML format. However, not all types of XML are valid SOAP Requests. SOAP defines a standard XML format. We will use WSDL (Web Service Definition Language) to define the format of request xml and the response xml.


Web_Services_WSDL_HighLevel

Now lets say Facebook wants to know how to call the TODO Service? What should I give to the Facebook developer? I will give him a WSDL. It will explain 
- What are the different services (operations) exposed by the server?
- How can a service (operation) be called? What url to use? (also called End Point).
- What should the structure of request xml?
- What should be the structure of response xml?

Web_Services_WSDL_SOAP_Envelope
SOAP format defines a SOAP-Envelope which envelopes the entire document. 
- SOAP-Header (optional) contains any information needed to identify the request. Also, part of the Header is authentication, authorization information (signatures, encrypted information etc). 
- SOAP-Body contains the real xml content of request or response.
- In case of error response, server responds back with SOAP-Fault.

Web_Services_WSDL_LowLevel


Isn't that cool?

### REST

First of all, REST does not define a standard message exchange format. You can build REST services with both XML and JSON. However, JSON is a more popular format with REST.

So, if it does not define a standard message exchange format, what is REST then?

> REST is a style of software architecture for distributed hypermedia systems

> REST stands for REpresentational State Transfer

Key abstraction in REST is a Resource. There is no restriction on what can be a resource. A todo is a resource. A person on facebook is a resource. 

A resource has an URI (Uniform Resource Identifier):
- /user/Ranga/todos/1
- /person/Ranga

A resource will have representations
- XML
- HTML
- JSON

A resource will have state. The representation of a resource should capture its current state.

When a resource is requested, we provide the representation of the resource. 

REST builds on top of HTTP (Hypertext Transfer Protocol). HTTP is the language of the web. 

HTTP has a few important verbs.
- POST - Create a new resource
- GET - Read a resource
- PUT - Update an existing resource
- DELETE - Delete a resource

HTTP also defines standard response codes.
- 200 - SUCESS
- 404 - RESOURCE NOT FOUND
- 400 - BAD REQUEST
- 201 - CREATED
- 401 - UNAUTHORIZED
- 415 - UNSUPPORTED TYPE - Representation not supported for the resource
- 500 - SERVER ERROR

Restful Service Constraints
- Client - Server : There should be a service producer and a service consumer.
- The interface (URL) is uniform and exposing resources. Interface uses nouns (not actions)
- The service is stateless. Even if the service is called 10 times, the result must be the same.
- The service result should be Cacheable. HTTP cache, for example.
- Service should assume a Layered architecture. Client should not assume direct connection to server - it might be getting info from a middle layer - cache.

Richardson Maturity Model defines the maturity level of a Restful Web Service. Following are the different levels and their characteristics.
- Level 0 : Expose SOAP web services in REST style. Expose action based services (http://server/getPosts, http://server/deletePosts, http://server/doThis, http://server/doThat etc) using REST.
- Level 1 : Expose Resources with proper URI’s (using nouns). Ex: http://server/accounts, http://server/accounts/10. However, HTTP Methods are not used.
- Level 2 : Resources use proper URI's + HTTP Methods. For example, to update an account, you do a PUT to . The create an account, you do a POST to . Uri’s look like posts/1/comments/5 and accounts/1/friends/1.
- Level 3 : HATEOAS (Hypermedia as the engine of application state). You will tell not only about the information being requested but also about the next possible actions that the service consumer can do. When requesting information about a facebook user, a REST service can return user details along with information about how to get his recent posts, how to get his recent comments and how to retrieve his friend’s list.

Designing Restful APIs
- While designing any API, the most important thing is to think about the api consumer i.e. the client who is going to use the service. What are his needs? Does the service uri make sense to him? Does the request, response format make sense to him?
- In Rest, we think Nouns (resources) and NOT Verbs (NOT actions). So, URI’s should represent resources. URI’s should be hierarchical and as self descriptive as possible. Prefer plurals.
- Always use HTTP Methods. 
  - GET : Should not update anything. Should be idempotent (same result in multiple calls). Possible Return Codes 200 (OK) + 404 (NOT FOUND) +400 (BAD REQUEST)
  - POST : Should create new resource. Ideally return JSON with link to newly created resource. Same return codes as get possible. In addition : Return code 201 (CREATED) is possible.
  - PUT : Update a known resource. ex: update client details. Possible Return Codes : 200(OK)
  - DELETE : Used to delete a resource.

## REST vs SOAP

REST vs SOAP are not really comparable. REST is an architectural style. SOAP is a message exchange format.

Let's compare the popular implementations of REST and SOAP styles.
- RESTful Sample Implementation : JSON over HTTP
- SOAP Sample Implementation : XML over SOAP over HTTP

- REST is built over simple HTTP protocol. SOAP services are more complex to implement and more complex to consume.
- REST has better performance and scalability. REST reads can be cached, SOAP based reads cannot be cached.
- REST permits many different data formats (JSON is the most popular choice) where as SOAP only permits XML.
- SOAP services have well defined structure and interface (WSDL) and has a set of well defined standards (WS-Security, WS-AtomicTransaction and WS-ReliableMessaging). Documentation standards with REST are evolving(We will use Swagger in this course).

## Advantages of Web Services

- Reuse : Mark Zuckerberg does not need to invest to build a todo application of his own.
- Modularity 
- Language Neutral

Webservices form the building blocks of SOA and microservices architectures.


# Building SOAP Services with Spring Web Services 

## Building an XSD

XSD is typically used to define how an XML should look like. 
- What should be the structure of an XML?
- What are the attributes that can be defined on an element?
- What is the data that can be defined on an element



## SOAP Service Examples

### XSD

```xsd
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://in28minutes.com/courses"
           targetNamespace="http://in28minutes.com/courses" elementFormDefault="qualified">

    <xs:element name="getCourseDetailsRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getCourseDetailsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="course" type="tns:course"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="course">
        <xs:sequence>
            <xs:element name="id" type="xs:string"/>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="description" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>

```

### Request
```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <getCourseDetailsRequest xmlns="http://in28minutes.com/courses">
            <id>Course1</id>
        </getCourseDetailsRequest>
    </Body>
</Envelope>
```

### Response
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCourseDetailsResponse xmlns:ns2="http://in28minutes.com/courses">
            <ns2:course>
                <ns2:id>Course1</ns2:id>
                <ns2:name>Spring</ns2:name>
                <ns2:description>10 Steps</ns2:description>
            </ns2:course>
        </ns2:getCourseDetailsResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Fault
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Server</faultcode>
            <faultstring xml:lang="en">java.lang.NullPointerException</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### WSDL

- view-source:http://localhost:8080/ws/courses.wsdl

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?><wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:sch="http://in28minutes.com/courses" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://in28minutes.com/courses" targetNamespace="http://in28minutes.com/courses">
  <wsdl:types>
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="http://in28minutes.com/courses">

    <xs:element name="getCourseDetailsRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getCourseDetailsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="course" type="tns:course"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="course">
        <xs:sequence>
            <xs:element name="id" type="xs:string"/>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="description" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>
  </wsdl:types>
  <wsdl:message name="getCourseDetailsRequest">
    <wsdl:part element="tns:getCourseDetailsRequest" name="getCourseDetailsRequest">
    </wsdl:part>
  </wsdl:message>
  <wsdl:message name="getCourseDetailsResponse">
    <wsdl:part element="tns:getCourseDetailsResponse" name="getCourseDetailsResponse">
    </wsdl:part>
  </wsdl:message>
  <wsdl:portType name="CoursesPort">
    <wsdl:operation name="getCourseDetails">
      <wsdl:input message="tns:getCourseDetailsRequest" name="getCourseDetailsRequest">
    </wsdl:input>
      <wsdl:output message="tns:getCourseDetailsResponse" name="getCourseDetailsResponse">
    </wsdl:output>
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="CoursesPortSoap11" type="tns:CoursesPort">
    <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
    <wsdl:operation name="getCourseDetails">
      <soap:operation soapAction=""/>
      <wsdl:input name="getCourseDetailsRequest">
        <soap:body use="literal"/>
      </wsdl:input>
      <wsdl:output name="getCourseDetailsResponse">
        <soap:body use="literal"/>
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="CoursesPortService">
    <wsdl:port binding="tns:CoursesPortSoap11" name="CoursesPortSoap11">
      <soap:address location="http://localhost:8080/ws"/>
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>
```


## WS-Security Examples

### Request
```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Header>
                <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" mustUnderstand="1">
                    <wsse:UsernameToken>
                        <wsse:Username>user</wsse:Username>
                        <wsse:Password>password</wsse:Password>
                    </wsse:UsernameToken>
                </wsse:Security>
            </Header>
    <Body>
        <getCourseDetailsRequest xmlns="http://in28minutes.com/courses">
            <id>Course1</id>
        </getCourseDetailsRequest>
    </Body>
</Envelope>
```

### Authentication Failure Responses

#### No Security Header
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Client</faultcode>
            <faultstring xml:lang="en">com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Invalid Credentials
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Client</faultcode>
            <faultstring xml:lang="en">com.sun.xml.wss.impl.WssSoapFaultException: Authentication of Username Password Token Failed; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.impl.WssSoapFaultException: Authentication of Username Password Token Failed</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### 

## Restful Examples



### GET Example
GET http://localhost:8080/users

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

### POST Example
POST http://localhost:8080/users

BODY
{
  "name": "Even",
  "birthDate": "2017-07-10T07:52:48.270+0000"
}

Response Status : 201 (CREATED)


### Pagination

#### Basic Pagination

```java
  @ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
  @GetMapping("/users")
  public Page<User> retrieveAllUsers(Pageable pageRequest) {
    return userService.findAll(pageRequest);
  }

```

http://localhost:8080/users-paged?size=4&sort=id,desc&page=3

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

#### Pagination with HATEOAS

```java
  @ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
  @GetMapping("/users-with-hateoas")
  public HttpEntity<PagedResources<User>> retrieveAllUsersWithHateoas(Pageable pageRequest,
        PagedResourcesAssembler assembler) {
    Page<User> users = userService.findAll(pageRequest);
    return new ResponseEntity<>(assembler.toResource(users), HttpStatus.OK);
  }
```

http://localhost:8080/users-with-hateoas?size=4&sort=id,desc&page=3

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

### Diagrams

graph LR
A[Facebook] --XML Request--> B(Todo Application)
B --XML Response--> A

graph LR
A[SOAP Envelope] --> B(SOAP Header)
B --> Authentication
B --> Authorization
B --> Signatures
A --> C(SOAP Body*)
C --> E(Request/Response Content)
A --> D(SOAP Fault*)
D --> F(Error Information)

graph LR
definitions --> types
types --> element
types --> complexType
definitions --> A(message)
definitions --> B(message)
definitions --> portType
portType --> E(operation)
E --> G(input)
E --> H(output)
binding --> F(operation)
F --> I(input)
F --> J(output)
definitions --> binding
definitions --> service
service --> port


# Introduction to the Course
 - Github Folders Overview
      - Spring 
      - Spring Boot
      - JPA
      - Restful Web Services
      - SOAP Web Services
 - Recommended path through the course
   - If you are already well versed with Spring and Spring Boot
   - If you are focused on RESTful Web Services
   - If you are focused on SOAP Web Services
   - If you want to do the entire courses
# Introduction to Web Services
 - What is a Web Service?
   - Data Exchange Formats
 - Overview of RESTful and SOAP Web Services
# Introduction to Spring
 - Intro Video??
 - DONE
# Introduction to Spring Boot
 - Intro Video??
 - DONE
# Introduction to SOAP Web Services
 - XML & XSD
 - WSDL
 - SOAP Envelope
 - Developing SOAP Web Services with Spring Web Services
# Implementing SOAP Web Services with Spring Boot, Spring and Spring Web Services
 - Create a new project
 - Designing the XSD
 - 
# Introduction to RESTful Web Services
# Basics of implementing RESTful Web Services With Spring Boot and Spring REST (Spring MVC)
# Introduction to Spring Data JPA
# Connecting RESTful Web Services with Spring Data JPA
# Advanced RESTful Features
# Best Practices in Designing Your RESTful APIs
# Architectural Best Practices & Governance for RESTful APIs
```
---

### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.web.services.soap</groupId>
	<artifactId>soap-web-services-in-10-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>soap-web-services-in-10-steps</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web-services</artifactId>
		</dependency>
		<dependency>
			<groupId>wsdl4j</groupId>
			<artifactId>wsdl4j</artifactId>
		</dependency>
		
		
		 <!-- WS-Security -->
        <dependency>
            <groupId>org.springframework.ws</groupId>
            <artifactId>spring-ws-security</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.security</groupId>
                    <artifactId>spring-security-core</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.wss</groupId>
            <artifactId>xws-security</artifactId>
            <version>3.0</version>
            <exclusions>
                <exclusion>
                    <groupId>javax.xml.crypto</groupId>
                    <artifactId>xmldsig</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>javax.activation</groupId>
            <artifactId>activation</artifactId>
            <version>1.1.1</version>
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
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<id>xjc</id>
						<goals>
							<goal>xjc</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
					<outputDirectory>${project.basedir}/src/main/java</outputDirectory>
					<clearOutputDir>false</clearOutputDir>
				</configuration>
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

### /src/main/java/com/in28minutes/courses/Course.java

```java
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.04 at 10:44:13 PM IST 
//


package com.in28minutes.courses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for course complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="course">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "course", propOrder = {
    "id",
    "name",
    "description"
})
public class Course {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
```
---

### /src/main/java/com/in28minutes/courses/GetCourseDetailsRequest.java

```java
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.04 at 10:44:13 PM IST 
//


package com.in28minutes.courses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id"
})
@XmlRootElement(name = "getCourseDetailsRequest")
public class GetCourseDetailsRequest {

    @XmlElement(required = true)
    protected String id;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
```
---

### /src/main/java/com/in28minutes/courses/GetCourseDetailsResponse.java

```java
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.04 at 10:44:13 PM IST 
//


package com.in28minutes.courses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="course" type="{http://in28minutes.com/courses}course"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "course"
})
@XmlRootElement(name = "getCourseDetailsResponse")
public class GetCourseDetailsResponse {

    @XmlElement(required = true)
    protected Course course;

    /**
     * Gets the value of the course property.
     * 
     * @return
     *     possible object is
     *     {@link Course }
     *     
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the value of the course property.
     * 
     * @param value
     *     allowed object is
     *     {@link Course }
     *     
     */
    public void setCourse(Course value) {
        this.course = value;
    }

}
```
---

### /src/main/java/com/in28minutes/courses/ObjectFactory.java

```java
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.04 at 10:44:13 PM IST 
//


package com.in28minutes.courses;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.in28minutes.courses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.in28minutes.courses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourseDetailsRequest }
     * 
     */
    public GetCourseDetailsRequest createGetCourseDetailsRequest() {
        return new GetCourseDetailsRequest();
    }

    /**
     * Create an instance of {@link GetCourseDetailsResponse }
     * 
     */
    public GetCourseDetailsResponse createGetCourseDetailsResponse() {
        return new GetCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

}
```
---

### /src/main/java/com/in28minutes/courses/package-info.java

```java
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.04 at 10:44:13 PM IST 
//

@javax.xml.bind.annotation.XmlSchema(namespace = "http://in28minutes.com/courses", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
package com.in28minutes.courses;
```
---

### /src/main/java/com/in28minutes/web/services/soap/CoursesEndpoint.java

```java
package com.in28minutes.web.services.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.Course;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
import com.in28minutes.web.services.soap.service.CourseService;

@Endpoint
public class CoursesEndpoint {
	private static final String NAMESPACE_URI = "http://in28minutes.com/courses";

	@Autowired
	private CourseService courseService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse getCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		com.in28minutes.web.services.soap.model.Course retrieveCourse = courseService.retrieveCourse(request.getId());
		if(retrieveCourse==null)
			throw new RuntimeException("Course with id " + request.getId() + " not found"); 
		
		response.setCourse(mapCourse(retrieveCourse));

		return response;
	}

	private Course mapCourse(com.in28minutes.web.services.soap.model.Course courseFromDb) {
		Course course = new Course();
		course.setName(courseFromDb.getName());
		course.setDescription(courseFromDb.getDescription());
		course.setId(courseFromDb.getId());
		return course;
	}
}
```
---

### /src/main/java/com/in28minutes/web/services/soap/model/Course.java

```java
package com.in28minutes.web.services.soap.model;

import java.util.List;

public class Course {
	private String id;
	private String name;
	private String description;
	private List<String> steps;

	// Needed by Caused by: com.fasterxml.jackson.databind.JsonMappingException:
	// Can not construct instance of com.in28minutes.springboot.model.Course:
	// no suitable constructor found, can not deserialize from Object value
	// (missing default constructor or creator, or perhaps need to add/enable
	// type information?)
	public Course() {

	}

	public Course(String id, String name, String description, List<String> steps) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.steps = steps;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public List<String> getSteps() {
		return steps;
	}

	@Override
	public String toString() {
		return String.format(
				"Course [id=%s, name=%s, description=%s, steps=%s]", id, name,
				description, steps);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
```
---

### /src/main/java/com/in28minutes/web/services/soap/service/CourseService.java

```java
package com.in28minutes.web.services.soap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.web.services.soap.model.Course;

@Component
public class CourseService {
	private static List<Course> courses = new ArrayList<>();

	static {
		// Initialize Data
		Course course1 = new Course("Course1", "Spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));
		Course course4 = new Course("Course4", "Maven", "Most popular maven course on internet!",
				Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}
	
	public Course retrieveCourse(String courseId) {
		for (Course course : courses) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}
		return null;
	}
}
```
---

### /src/main/java/com/in28minutes/web/services/soap/SoapWebServicesIn10StepsApplication.java

```java
package com.in28minutes.web.services.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapWebServicesIn10StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapWebServicesIn10StepsApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/web/services/soap/WebServiceConfig.java

```java
package com.in28minutes.web.services.soap;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet messageServlet = new MessageDispatcherServlet();
		messageServlet.setApplicationContext(applicationContext);
		messageServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageServlet, "/ws/*");
	}

	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseDetailsSchema) {
		DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
		wsdlDefinition.setPortTypeName("CoursesPort");
		wsdlDefinition.setLocationUri("/ws");
		wsdlDefinition.setTargetNamespace("http://in28minutes.com/courses");
		wsdlDefinition.setSchema(courseDetailsSchema);
		return wsdlDefinition;
	}

	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
		securityInterceptor.setCallbackHandler(callbackHandler());
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		return securityInterceptor;
	}

	@Bean
	SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
		callbackHandler.setUsersMap(Collections.singletonMap("user", "password"));
		return callbackHandler;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}
}
```
---

### /src/main/resources/application.properties

```properties
#logging.level.org.springframework=DEBUG
```
---

### /src/main/resources/course-details.xsd

```
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://in28minutes.com/courses"
           targetNamespace="http://in28minutes.com/courses" elementFormDefault="qualified">

    <xs:element name="getCourseDetailsRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getCourseDetailsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="course" type="tns:course"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="course">
        <xs:sequence>
            <xs:element name="id" type="xs:string"/>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="description" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>
```
---

### /src/main/resources/securityPolicy.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xwss:SecurityConfiguration xmlns:xwss="http://java.sun.com/xml/ns/xwss/config">
	<xwss:RequireUsernameToken
		passwordDigestRequired="false" nonceRequired="false" />
</xwss:SecurityConfiguration>
```
---

### /src/test/java/com/in28minutes/web/services/soap/SoapWebServicesIn10StepsApplicationTests.java

```java
package com.in28minutes.web.services.soap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoapWebServicesIn10StepsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /useful-files-not-used-in-project/courses_generated_by_spring_ws.wsdl

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns:sch="http://in28minutes.com/courses" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:tns="http://in28minutes.com/courses" targetNamespace="http://in28minutes.com/courses">
	<wsdl:types>
		<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
			elementFormDefault="qualified" targetNamespace="http://in28minutes.com/courses">

			<xs:element name="getCourseDetailsRequest">
				<xs:complexType>
					<xs:sequence>
						<xs:element name="id" type="xs:string" />
					</xs:sequence>
				</xs:complexType>
			</xs:element>

			<xs:element name="getCourseDetailsResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element name="course" type="tns:course" />
					</xs:sequence>
				</xs:complexType>
			</xs:element>

			<xs:complexType name="course">
				<xs:sequence>
					<xs:element name="id" type="xs:string" />
					<xs:element name="name" type="xs:string" />
					<xs:element name="description" type="xs:string" />
				</xs:sequence>
			</xs:complexType>
		</xs:schema>
	</wsdl:types>
	<wsdl:message name="getCourseDetailsRequest">
		<wsdl:part element="tns:getCourseDetailsRequest" name="getCourseDetailsRequest">
		</wsdl:part>
	</wsdl:message>
	<wsdl:message name="getCourseDetailsResponse">
		<wsdl:part element="tns:getCourseDetailsResponse" name="getCourseDetailsResponse">
		</wsdl:part>
	</wsdl:message>
	<wsdl:portType name="CoursesPort">
		<wsdl:operation name="getCourseDetails">
			<wsdl:input message="tns:getCourseDetailsRequest" name="getCourseDetailsRequest">
			</wsdl:input>
			<wsdl:output message="tns:getCourseDetailsResponse" name="getCourseDetailsResponse">
			</wsdl:output>
		</wsdl:operation>
	</wsdl:portType>
	<wsdl:binding name="CoursesPortSoap11" type="tns:CoursesPort">
		<soap:binding style="document"
			transport="http://schemas.xmlsoap.org/soap/http" />
		<wsdl:operation name="getCourseDetails">
			<soap:operation soapAction="" />
			<wsdl:input name="getCourseDetailsRequest">
				<soap:body use="literal" />
			</wsdl:input>
			<wsdl:output name="getCourseDetailsResponse">
				<soap:body use="literal" />
			</wsdl:output>
		</wsdl:operation>
	</wsdl:binding>
	<wsdl:service name="CoursesPortService">
		<wsdl:port binding="tns:CoursesPortSoap11" name="CoursesPortSoap11">
			<soap:address location="http://localhost:8080/ws" />
		</wsdl:port>
	</wsdl:service>
</wsdl:definitions>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsRequest.xml

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <getCourseDetailsRequest xmlns="http://in28minutes.com/courses">
            <id>Course1</id>
        </getCourseDetailsRequest>
    </Body>
</Envelope>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsRequest_withSecurity.xml

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Header>
                <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" mustUnderstand="1">
                    <wsse:UsernameToken>
                        <wsse:Username>user</wsse:Username>
                        <wsse:Password>password</wsse:Password>
                    </wsse:UsernameToken>
                </wsse:Security>
            </Header>
    <Body>
        <getCourseDetailsRequest xmlns="http://in28minutes.com/courses">
            <id>Course1</id>
        </getCourseDetailsRequest>
    </Body>
</Envelope>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsResponse_Fault_Exception.xml

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Server</faultcode>
            <faultstring xml:lang="en">java.lang.NullPointerException</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsResponse_Fault_Security_Failed_Authentication.xml

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Client</faultcode>
            <faultstring xml:lang="en">com.sun.xml.wss.impl.WssSoapFaultException: Authentication of Username Password Token Failed; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.impl.WssSoapFaultException: Authentication of Username Password Token Failed</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsResponse_Fault_Security_No_Header.xml

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Client</faultcode>
            <faultstring xml:lang="en">com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found; nested exception is com.sun.xml.wss.XWSSecurityException: com.sun.xml.wss.XWSSecurityException: Message does not conform to configured policy [ AuthenticationTokenPolicy(S) ]:  No Security Header found</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
---

### /useful-files-not-used-in-project/GetCourseDetailsResponse_Success.xml

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCourseDetailsResponse xmlns:ns2="http://in28minutes.com/courses">
            <ns2:course>
                <ns2:id>Course1</ns2:id>
                <ns2:name>Spring</ns2:name>
                <ns2:description>10 Steps</ns2:description>
            </ns2:course>
        </ns2:getCourseDetailsResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
---
