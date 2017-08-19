package com.in28minutes.jpa.jpademo.inheritence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "disc_type")
public abstract class Employee {

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	@GeneratedValue
	@Id
	protected Integer id;

	private String name;

}