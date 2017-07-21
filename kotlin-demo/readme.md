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

## Complete Code Example


### /src/com/demo/kotlin/Person.kt

```
package com.demo.kotlin

data class Person(val firstName: String,
				  val lastName: String,
				  val age: Int,
				  val ssn: String)

fun welcomePerson(name: String = "Raja") = "hi, ${name}"

fun printWelcomeString(name: String = "Raja") = println("printWelcomeString hi, ${name}")

fun main(args: Array<String>) {	

	//No need for semicolon

	//Variables	
	
	//No need for variable type. Type is inferred.

	//But it is type safe
	var z = 1
	//z = "abc"

	//Mutability of variables
	var i =5
	i = 10
	val k = 10
	//k = 123

	//Functions
	//Default arguments
	//Single expression functions
	println(welcomePerson(name = "Ranga"))
	println(welcomePerson())
	printWelcomeString()

	//Data Classes
	val person = Person("Ranga", "Karanam", 25, "99-999-9999")
	println(person) //default toString
	

	//Copy
	val personClone = person.copy(firstName = "Raja")
	println(personClone)

	//Destructure
	val (firstName, lastName, age, ssn) = personClone;

	println("$firstName $lastName $age $ssn");
}
```
---
