# Getting Started in 5 Steps
Learn to install and get started with Java, Eclipse, Maven, JUnit, Mockito, Spring, Spring Boot &amp; Kotlin in 5 easy steps

# Overview

- Setting up these examples
 - Video link - TODO
- Languages/Tools
  - [Java](#java)
  - [Eclipse](#eclipse)
  - [Embedded Maven in Eclipse](#embedded-maven-in-eclipse)
  - [Maven](#maven-standalone)
  - [Kotlin](#kotlin)
  - [H2](#h2-in-memory-database)
  - MySQL [COMING SOON]
- Frameworks
  - [Spring](#spring)
  - [Spring Boot](#spring-boot)
  - [JUnit](#junit)
  - [Mockito](#Mockito)

# Java
- Most popular language
- http://github.com/in28minutes/getting-started-in-5-steps#Java

## Prerequisites
- None

## Installation

1. Search for “install java jdk” on google. 
![Image](/images/google-search-install-java-jdk.png)

2. Choose the first link. You should go to the oracle site. The direct link is http://www.oracle.com/technetwork/java/javase/downloads/index.html
![Image](/images/oracle-website-java-installation.png)

3. Select the Java Platform JDK Link.  
![Image](/images/java-installation-icon.png)

4. Accept the license agreement.  
![Image](/images/oracle-java-license-agreement.png)

5. Choose the Java Install for your Operating System.  If you are windows 64 bit operating system, choose the Windows x64 java. If you are using windows and do not know if you are using 64-bit or 32-bit, you can visit https://support.microsoft.com/en-ae/help/15056/windows-7-32-64-bit-faq.
![Image](/images/choose-java-installation-for-your-os.png)

6. Wait for the download to complete. Double click the file from the downloads folder.
Java Installer would launch up. Click Continue.  
![Image](/images/java-installation-first-step.png)

7. Click install on the next screen 
![Image](/images/java-installation-second-step.png)

8. Have a coffee and wait for the installation to complete. When the installation is complete, you would see the screen below:  
![Image](/images/java-installation-confirmation.png)

9. Click close. We are ready to Rock and Roll. Do a Dance.

## Check
1. If you are on Windows : Open the Command Prompt window by 
  * Click the Start button
  * Select All Programs -> Accessories > Command Prompt. 
  * Or use Ctrl + Esc, and type in cmd and launch up command.
2. If you are on Mac or other OS, launch up Terminal.
	* cmd + space -> Type terminal -> Press enter
3. Type in the command “java –version” as shown in the screen. If it does not work, go to the trouble shooting section.
![Image](/images/java-version-command.png)

## Troubleshooting
1.	Check if there are any pre-existing Java installs. Uninstall them and reinstall again.
2.	Temporarily turn off firewalls and antivirus software.
3.	If you get file corrupt message, download the installation file again.
4.	Check if you are on 32-bit OS or 64-bit OS and ensure you are making use of the right java download.

# Eclipse

Eclipse is the most popular open source Java IDE.

## Prerequisites
- Java JDK 8

## Installation
1. Check if Java is installed properly. Open terminal or command prompt. Type in the command “java –version” as shown in the screen. If it does not work, go to the trouble shooting section of Java or Reinstall Java.  Minimum Java JDK Version is Java 8.
![Image](/images/java-version-command.png)

2. Search google for “download eclipse” and choose the first result. The direct link is http://www.eclipse.org/downloads/eclipse-packages/.
![Image](/images/google-search-download-eclipse.png)

3. Choose the right Operation System. 
![Image](/images/eclipse-choose-installation.png)

4. We recommend to choose “Eclipse IDE for Java EE Developers”. Choose 32 bit or 64 bit based on your operating system. (Right-click My Computer, and then click Properties. If "x64 Edition" is listed under System, your processor is capable of running a 64-bit version of Windows.)

5. Wait for the download to complete. Extract the zip file to a folder (Example : c:\eclipse).

6. That it you are ready to launch up eclipse

## Check

- We will use the first step to check if eclipse is properly installed.

## Troubleshooting

- You should use a JDK with Eclipse (not a JRE)
  - (Window/Eclipse) -> Preferences -> Java -> Installed JRE's
- Note that there is a known problem with the built-in decompression utility on all current versions of Windows. We recommend that you use a more robust decompression utility such as the open source 7zip when decompressing an Eclipse download. Some people report success when initially decompressing Eclipse into a root directory (e.g. c:\) and then moving it to a more appropriate home (e.g. c:\Program Files\Eclipse)
- Refer to Troubleshooting section of https://wiki.eclipse.org/Eclipse/Installation for more details about troubleshooting Installations

## First 5 Steps

> If you are using mac, use Cmd instead of Ctrl. 

> In Windows, use Windows -> Preferences for Preferences.

- Step 1 : Create a Java Project 
  - Create and run a Java class
  - Create and run a JUnit test
- Step 2 : Keyboard Shortcuts
  - Ctrl + Space
    - BigDecimal - Auto Suggestion
    - File Name and Class Name does not match - Display Errors
    - Templates - main, fore, sysout, syserr
  - Ctrl + 1
    - Rename a Class - What suggestions are offered?
    - new Integer() - What suggestions are offered?
  - Ctrl + Shift + R (and T)
  - F3 (Goto declaration)
  - F4 (Type Hierarchy)
  - Ctrl + Shift + L
- Step 3 : Views and Perspectives
- Step 4 : Save Actions
- Step 5 : Code Generation
    - Alt + Shift + S
      - Getters and Setters
      - toString()
      - equals()
      - hashcode()

# Embedded Maven in Eclipse

## Prerequisites

- Java
- Eclipse (When using embedded eclipse)

## Installation
- If you are a beginner, we recommended to use Maven embedded in Eclipse. If you have your feet firmly on ground, go to the section on standalone installation.

## Check
- Import a Maven Project into eclipse
  - We will this example - https://github.com/in28minutes/SpringMvcStepByStep
  - Run basic maven commands

## Troubleshooting Embedded Maven in Eclipse

## First 5 Steps
Refer First 5 Steps of Maven Standalone below.

# Maven Standalone
- For most purposes, we recommend using embedded maven in Eclipse.

## Prerequisites
- Java

## Installation
1. Check if Java is installed properly. Type in the command “java –version” as shown in the screen. If it does not work, go to the trouble shooting section of Java or Reinstall Java.  
![Image](/images/java-version-command.png)

> Note that Maven 3.3 requires JDK 1.7 or above, Maven 3.2 requires JDK 1.6 or above, while Maven 3.0/3.1 requires JDK 1.5 or above.

Download Apache Maven from Maven official website, https://maven.apache.org. Example : apache-maven-3.3.3-bin.zip 

![Image](/images/maven-download.png)

#### On Windows
1. Unzip the distribution archive, i.e. apache-maven-3.3.3-bin.zip to the directory you wish to install Maven 3.3.3. These instructions assume you chose C:\maven. The subdirectory apache-maven-3.3.3 will be created from the archive. Have no spaces in the folder path.
2. Add the unpacked distribution's bin directory to your user PATH environment variable by opening up the system properties (WinKey + Pause), selecting the "Advanced" tab, and the "Environment Variables" button, then adding or selecting the PATH variable in the user variables with the value C:\maven\apache-maven-3.3.3\bin.
3. You can check if you are using the right value by opening up the folder using “cd C:\maven\apache-maven-3.3.3\bin” and then typing the command “mvn --version”.
4. Make sure that JAVA_HOME exists in your user variables or in the system variables and it is set to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_51.
5. Open a new command prompt (Winkey + R then type cmd) (or terminal on mac) and run “mvn –version” to verify that it is correctly installed.  
![Image](/images/maven-check-installation.png)
6. Refer https://www.mkyong.com/maven/how-to-install-maven-in-windows/ or https://www.tutorialspoint.com/maven/maven_environment_setup.htm for more details.

#### Unix-based Operating Systems (Linux, Solaris and Mac OS X)
1. Extract the distribution archive, i.e. apache-maven-3.3.3-bin.tar.gz to the directory you wish to install Maven 3.3.3. These instructions assume you chose /usr/local/apache-maven. The subdirectory apache-maven-3.3.3 will be created from the archive.
2. In a command terminal, add unpacked distribution's bin to your PATH environment variable, e.g. export PATH=$PATH:/usr/local/apache-maven/apache-maven-3.3.3/bin.
3. Make sure that JAVA_HOME is set to the location of your JDK, e.g. export JAVA_HOME=/usr/java/jdk1.7.0_51 .
4. If you are having problems refer https://stackoverflow.com/questions/8826881/maven-install-on-mac-os-x

## Check
* Run mvn --version to verify that it is correctly installed.  
![Image](/images/maven-check-installation.png)

## Troubleshooting

## First 5 Steps

### Step 1 : Creating a Maven project
 - Create a java project with a class and unit test
 - run "mvn clean install" 
 - Build LifeCycle - Validate, Compile, Test, Package, Integration Test, Verify, Install, Deploy
 - Convention over Configuration - Pre defined folder structure
	- Source Code
		- ${basedir}/src/main/java
		- ${basedir}/src/main/resources
	- Test Code
		- ${basedir}/src/test

### Step 2 : Import a Maven project
  - We will this example - https://github.com/in28minutes/SpringMvcStepByStep
  - Run basic maven commands
    - mvn tomcat7:run

### Step 3 : Basic Maven Commands
 - mvn --version
 - mvn compile (compiles source files)
 - mvn test-compile (compiles test files) - one thing to observe is this also compiles source files
 - mvn clean - deletes target directory
 - mvn test - run unit tests
 - mvn package - creates the jar

### Step 4 : How does Maven Work?
 - Local Repository
 - Maven repository 
   - stores all the versions of all dependencies. JUnit 4.2,4.3,4.4
   - mvn install - copies the created jar to local maven repository - a temp folder on my machine where maven stores the files.

### Step 5 : Advanced Maven Commands
- help:effective-settings
- help:effective-pom
- dependency:tree
- dependency:sources
- --debug
- Maven Archetypes -> archetype:generate

### Next Steps

# JUnit

## Prerequisites
- Java
- Eclipse
  - Embedded Maven in Eclipse

## First 5 Steps
### Step 1 : First JUnit Project and Green Bar
 - What is JUnit?
 - First Project with JUnit
 - First JUnit Class
 - No Failure is Success
### Step 2 : First Code and First Unit Test
 - MyMath class with sum method
 - Unit test for the sum method
### Step 3 : Other assert methods
 - assertTrue and assertFalse methods
### Step 4 : Important annotations
  - @Before @After annotations
  - @BeforeClass @AfterClass annotations
### Step 5 : Advantages of Unit Testing and How to make best use of JUnit?
- JUnit tests are automated vs Manual Testing
- Run in Continuous Integration - Jenkins
### Next Steps

# Mockito

Visit Mockito Official Documentation - [Mockito Documentation] (http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)

## Prerequisites
- Java
- Eclipse
  - Embedded Maven in Eclipse
- Knowledge of JUnit
- Easier Static Imports

  - Window > Preferences > Java > Editor > Content Assist > Favorites
    - org.junit.Assert
    - org.mockito.BDDMockito
    - org.mockito.Mockito
    - org.hamcrest.Matchers
    - org.hamcrest.CoreMatchers

## First 5 Steps
### Step 1 : Setting up an example
### Step 2 : Stubs.
### Step 3 : Your first mock. 
### Step 4 : Mockito Annotations. @Mock, @InjectMocks, @RunWith(MockitoJUnitRunner.class)
### Step 5 : Mocking List interface
### Next Steps

# Spring

## Prerequisites
- Java
- Eclipse
  - Embedded Maven in Eclipse

## First 5 Steps - Actually 6
### Step 1 : First Spring Example - Searching and Sorting - Setup
### Step 2 : First Spring Example - Searching and Sorting - Refactoring
### Step 3 : First Spring Example - Searching and Sorting - Using Spring
### Step 4 : Important Spring Annotations - @Component, @Autowired
### Step 5 : Spring Application Context - Container Managed Beans
### Step 6 : Types of Dependency Injection
### Next Steps

# Spring Boot

Coming Soon..

## Prerequisites
- Java
- Eclipse
  - Embedded Maven in Eclipse

## First 5 Steps
### Step 1 : Setup and Launch with Spring Initializr
### Step 2 : Create a Simple REST Controller
### Step 3 : Spring Boot vs Spring vs Spring MVC
### Step 4 : Spring Boot Actuator
### Step 5 : Embedded servlet containers : Switch to Jetty or Undertow
### Next Steps

# Kotlin

Quotes from Andrey Breslav, Kotlin language designer

> The primary purpose of Project Kotlin is to create for developers a general-purpose language that can serve as a useful tool that is safe, concise, flexible, and 100 percent Java-compatible

> Kotlin is designed to be an industrial-strength object-oriented language, and a "better language" than Java, but still be fully interoperable with Java code, allowing companies to make a gradual migration from Java to Kotlin.

## Prerequisites
- Java
- Eclipse

## Installation
Installing Kotlin Java Plugin - https://marketplace.eclipse.org/content/kotlin-plugin-eclipse

## First 5 Steps
### Step 1 : Introduction to Kotlin
### Step 2 : First Kotlin Java Project and class
### Step 3 : Basics - Variables in Kotlin
### Step 4 : Functions in Kotlin
### Step 5 : Kotlin Data Class
### Next Steps

# H2 in-memory database

Coming Soon..

## Prerequisites
- None

## Installation
- We will use a Spring Boot application to set it up.


## Useful Snippets

### Dependencies
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

### Entity bean
```
@Entity
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

### Repository
```
public interface UserRepository extends CrudRepository<User, Long> {
}
```


### Using Repository to instantiate data
```
@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) {
        // save a couple of customers
        repository.save(new User("Ranga", "Admin"));
        repository.save(new User("Ravi", "User"));
        repository.save(new User("Satish", "Admin"));
        repository.save(new User("Raghu", "User"));

        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }

    }

}
```

Useful Properties
```
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.initialize=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Look at H2 Console : http://localhost:8080/h2-console
Use db url jdbc:h2:mem:testdb

## First 5 Steps
### Step 1 : Import an exising project using inmemory database
### Step 2 : Understanding the JPA Project
### Step 3 : Using in-memory database in Unit Tests
### Step 4 : Using in-memory database to run actual application
### Step 5 : Using H2 Console
### Next Steps

# MySql

Coming Soon..

## Prerequisites
- None

## Installing

## Check

## Trouble Shooting