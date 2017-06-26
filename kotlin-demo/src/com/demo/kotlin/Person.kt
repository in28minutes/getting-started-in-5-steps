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
