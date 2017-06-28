# Getting Started in 5 Steps
Learn to install and get started with Java, Eclipse, Maven, JUnit, Mockito, Spring, Spring Boot &amp; Kotlin in 5 easy steps

# Begin with End in Mind
- Help as installation guides for all courses
- Help troubleshoot installation issues especially those with Maven
- Help as introduction to basic frameworks in other courses

# Overview

- Setting up these examples
- Installing & Troubleshooting
  - [Overview](#overview)
    - Video Playlist - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3
  - [Java](#java)
  - [Eclipse](#eclipse)
  - [Embedded Maven in Eclipse](#testing-eclipse-with-embedded-maven)
  - [Troubleshooting Eclipse with Embedded Maven](#troubleshooting-eclipse-with-embedded-maven)
- Taking First 5 Steps
  - [Eclipse](#first-5-steps-in-eclipse)
  - [Maven](#first-5-steps-in-maven)
  - [Spring](#first-5-steps-in-spring)
  - [Spring Boot](#first-5-steps-in-spring-boot)
  - [JUnit](#first-5-steps-in-junit)
  - [Mockito](#first-5-steps-in-mockito)
  - [Kotlin](#first-5-steps-in-kotlin)
  - [H2](#first-5-steps-in-h2-in-memory-database)


# Installation & Troubleshooting

- Video link - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3

## Java
- Most popular language
- Video - https://www.youtube.com/watch?v=9bdgxY841v0&list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3&index=2

### Prerequisites
- None

### Installation

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

### Check
1. If you are on Windows : Open the Command Prompt window by
  * Click the Start button
  * Select All Programs -> Accessories > Command Prompt. 
  * Or use Ctrl + Esc, and type in cmd and launch up command.
2. If you are on Mac or other OS, launch up Terminal.
	* cmd + space -> Type terminal -> Press enter
3. Type in the command “java –version” as shown in the screen. If it does not work, go to the trouble shooting section.
![Image](/images/java-version-command.png)

### Troubleshooting
1.	Check if there are any pre-existing Java installs. Uninstall them and reinstall again.
2.	Temporarily turn off firewalls and antivirus software.
3.	If you get file corrupt message, download the installation file again.
4.	Check if you are on 32-bit OS or 64-bit OS and ensure you are making use of the right java download.

## Eclipse

Eclipse is the most popular open source Java IDE.

Installation Video - https://www.youtube.com/watch?v=-KV0QIqh2kA&list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3&index=3

### Prerequisites
- Java JDK 8

### Installation
1. Search google for “download eclipse” and choose the first result. The direct link is http://www.eclipse.org/downloads/eclipse-packages/.
![Image](/images/google-search-download-eclipse.png)

2. Choose the right Operation System. 
![Image](/images/eclipse-choose-installation.png)

3. We recommend to choose “Eclipse IDE for Java EE Developers”. Choose 32 bit or 64 bit based on your operating system. (Right-click My Computer, and then click Properties. If "x64 Edition" is listed under System, your processor is capable of running a 64-bit version of Windows.)

4. Wait for the download to complete. Extract the zip file to a folder (Example : c:\eclipse).

5. That it you are ready to launch up eclipse

### Troubleshooting
- Use 7Zip instead of windows built-in decompression utility.
- Unzip to root folder (e.g. c:\) compared to a long directory path (e.g. c:\Program Files\Eclipse).
- Some instructions at https://wiki.eclipse.org/Eclipse/Installation#Troubleshooting

## Testing Eclipse with Embedded Maven

Maven is one of the most popular Java build tools. Its is used to manage dependencies of java projects and build deployable units. We will use embedded maven in eclipse in our course. 

Video - https://www.youtube.com/watch?v=g8Sw0UPPjKY&list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3&index=4

We will do the following things to test our embedded maven installation:
- Create a new Eclipse workspace
- Download a new Spring Boot project from http://start.spring.io
- Import and run the Spring Boot Project

### Troubleshooting Eclipse with Embedded Maven

> In Windows, use Windows -> Preferences for Preferences.

Video - https://www.youtube.com/watch?v=ZZw8XNz5N-c&list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3&index=5

- Things you would need to understand
  - You should use a JDK with Eclipse 
     - [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.2:compile (default-compile) on project in28minutes-multi-module-model: Compilation failure [ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
     - (Window/Eclipse) -> Preferences -> Java -> Installed JRE's
  - You need to be connected to internet
     - Maven-Error-Dependencies-Cannot-Be-Resolved - You are unable to connect to the maven repository to download the required plugins
  - Configuring a Proxy 
     - Maven plugin uses a settings file where the configuration can be set. Its path is available in Eclipse at Window|Preferences|Maven|User Settings. If the file doesn't exist, create it and put on something like the example below
  - Force download of dependencies
     - ```mvn dependency:purge-local-repository```
     - Delete your local repository - LAST OPTION


```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <localRepository/>
  <interactiveMode/>
  <usePluginRegistry/>
  <offline/>
  <pluginGroups/>
  <servers/>
  <mirrors/>
  <proxies>
    <proxy>
      <id>myproxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>192.168.1.100</host>
      <port>6666</port>
      <username></username>
      <password></password>
      <nonProxyHosts>localhost|127.0.0.1</nonProxyHosts>
    </proxy>
  </proxies>
  <profiles/>
  <activeProfiles/>
</settings>
```


## Maven Standalone
- For most purposes, we recommend using embedded maven in Eclipse. Video - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3

### Prerequisites
- Java

### Installation
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

### Check
* Run mvn --version to verify that it is correctly installed.  
![Image](/images/maven-check-installation.png)

## MySql

Coming Soon..

### Prerequisites
- None

### Installing

### Check

### Trouble Shooting

# First 5 Steps

## First 5 Steps in Eclipse

- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps
- Pre-requisites - Java & Eclipse - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3

> If you are using mac, use Cmd instead of Ctrl. 
> In Windows, use Windows -> Preferences for Preferences.

- Step 1 : Create a Java Project 
  - Create and run a Java class
- Step 2 : Keyboard Shortcuts
  - Ctrl + Space
    - BigDecimal - Auto Suggestion
    - Templates - main, fore, sysout, syserr
  - Ctrl + 1
    - File Name and Class Name does not match - Display Errors
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

## First 5 Steps in Maven

- Defining what Maven does is very difficult.

- Every Day Developer does a lot of things
   - Manages Dependencies - Web Layer (Spring MVC), Data Layer (JPA - Hibernate) etc..                  
   - Build a jar or a war or an ear
   - Run the application locally - Tomcat or Jetty
   - Deploy to a T environment
   - Add new dependencies to a project
   - Run Unit Tests

- Maven helps us do all these and more...
   - Generate Projects
   - Create Eclipse Workspace

### Getting Started 
- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps
- Pre-requisites - Java & Eclipse - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3
- We will use embedded maven in Eclipse

### Step 1 : Creating and importing a Maven Project
 - We will create a Spring Boot project using http://start.spring.io
 - We will import it into Eclipse as a Maven Project

### Step 2 : Understanding Project Object Model - pom.xml
 - Naming a project
 - Declaring Dependencies

### Step 3 : Maven Build Life Cycle
 - run "mvn clean install" 
 - Build LifeCycle - Validate, Compile, Test, Package, Integration Test, Verify, Install, Deploy
 - Convention over Configuration - Pre defined folder structure
	- Source Code
		- ${basedir}/src/main/java
		- ${basedir}/src/main/resources
	- Test Code
		- ${basedir}/src/test

### Step 4 : How does Maven Work?
 - Local Repository
 - Maven repository 
   - stores all the versions of all dependencies. JUnit 4.2,4.3,4.4
   - mvn install - copies the created jar to local maven repository - a temp folder on my machine where maven stores the files.

### Step 5 : Important Maven Commands
 - mvn --version
 - mvn compile (compiles source files)
 - mvn test-compile (compiles test files) - one thing to observe is this also compiles source files
 - mvn clean - deletes target directory
 - mvn test - run unit tests
 - mvn package - creates the jar
- help:effective-settings
- help:effective-pom
- dependency:tree
- dependency:sources
- --debug

### Next Steps

## First 5 Steps in JUnit

- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps
- Pre-requisites - Java & Eclipse - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3
- We will use embedded maven in Eclipse

### Step 1 : What is JUnit and Unit Testing?
 - What is JUnit?
 - What is Unit Testing?
 - Advantages of Unit Testing

### Step 2 : First JUnit Project and Green Bar
 - What is JUnit?
 - First Project with JUnit
 - First JUnit Class
 - No Failure is Success
 - MyMath class with sum method

### Step 3 : First Code and First Unit Test
 - Unit test for the sum method

### Step 4 : Other assert methods
 - assertTrue and assertFalse methods

### Step 5 : Important annotations
  - @Before @After annotations
  - @BeforeClass @AfterClass annotations

### Next Steps

## First 5 Steps in Mockito

- Visit Mockito Official Documentation - [Mockito Documentation] (http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)
- Easier Static Imports
  - Window > Preferences > Java > Editor > Content Assist > Favorites
    - org.junit.Assert
    - org.mockito.BDDMockito
    - org.mockito.Mockito
    - org.hamcrest.Matchers
    - org.hamcrest.CoreMatchers

- Step 1 : Setting up an example.
- Step 2 : Using a Stubs - Disadvantages
- Step 3 : Your first mock. 
- Step 4 : Using Mockito Annotations - @Mock, @InjectMocks, @RunWith(MockitoJUnitRunner.class)
- Step 5 : Mocking List interface
- Next Steps

##  First 5 Steps in Spring

- Step 1 : First Spring Example - Searching and Sorting - Setup
- Step 2 : First Spring Example - Searching and Sorting - Refactoring
- Step 3 : First Spring Example - Searching and Sorting - Using Spring
- Step 4 : Important Spring Annotations - @Component, @Autowired
- Step 5 : Spring Application Context - Container Managed Beans
- Step 6 : Types of Dependency Injection
- Next Steps

##  First 5 Steps in Spring Boot

- Step 1 : Setup and Launch with Spring Initializr
- Step 2 : Create a Simple REST Controller
- Step 3 : Spring Boot vs Spring vs Spring MVC
- Step 4 : Spring Boot Actuator
- Step 5 : Embedded servlet containers : Switch to Jetty or Undertow
- Next Steps

##  First 5 Steps in Kotlin

Quotes from Andrey Breslav, Kotlin language designer

> The primary purpose of Project Kotlin is to create for developers a general-purpose language that can serve as a useful tool that is safe, concise, flexible, and 100 percent Java-compatible

> Kotlin is designed to be an industrial-strength object-oriented language, and a "better language" than Java, but still be fully interoperable with Java code, allowing companies to make a gradual migration from Java to Kotlin.

- Step 0 : Installing Kotlin Java Plugin - https://marketplace.eclipse.org/content/kotlin-plugin-eclipse
- Step 1 : Introduction to Kotlin
- Step 2 : First Kotlin Java Project and class
- Step 3 : Basics - Variables in Kotlin
- Step 4 : Functions in Kotlin
- Step 5 : Kotlin Data Class
- Next Steps

##  First 5 Steps in H2 in-memory database

- Step 1 : Import an exising project using inmemory database
- Step 2 : Understanding the JPA Project
- Step 3 : Using in-memory database in Unit Tests
- Step 4 : Using in-memory database to run actual application
- Step 5 : Using H2 Console 
- Next Steps

Notes
- http://localhost:8080/h2-console
- Use db url jdbc:h2:mem:testdb