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
- Taking First Steps
  - [Eclipse](eclipse-in-5-steps)
  - [Maven](maven-in-5-steps)
  - [Spring](spring-in-10-steps)
  - [Spring Boot](springboot-in-10-steps)
  - [JUnit](junit-in-5-steps)
  - [Mockito](mockito-in-5-steps)
  - [Kotlin](kotlin-demo)
  - [JPA](jpa-in-10-steps)


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

## Installing and Setting Up MySQL

- Install MySQL https://dev.mysql.com/doc/en/installing.html
  - More details : http://www.mysqltutorial.org/install-mysql/
- Startup the Server (as a service)
- Go to command prompt (or terminal)
   - Execute following commands to create a database and a user

```
mysql --user=user_name --password db_name
create database todo_example;
create user 'todouser'@'localhost' identified by 'YOUR_PASSWORD';
grant all on todo_example.* to 'todouser'@'localhost';
```

- Execute following sql queries to create the table and insert the data

Table
```sql
create table todo 
(id integer not null, 
desc varchar(255), 
is_done boolean not null, 
target_date timestamp, 
user varchar(255), 
primary key (id));
```

Data
```sql
INSERT INTO TODO
VALUES(10001, 'Learn Spring Boot', false, sysdate(),'in28Minutes');

INSERT INTO TODO
VALUES(10002, 'Learn RESTful Web Services', false, sysdate(),'in28Minutes');

INSERT INTO TODO
VALUES(10003, 'Learn SOAP Web Services', false, sysdate(),'in28Minutes');
```

## Code changes to connect to MySQL
- Add dependency to pom.xml (and remove H2 dependency)
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```
- Configure application.properties

```properties
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/todo_example
spring.datasource.username=todouser
spring.datasource.password=YOUR_PASSWORD
```

- Restart and You are ready!

### Trouble Shooting
- https://dev.mysql.com/doc/refman/en/problems.html