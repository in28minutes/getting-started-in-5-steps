package com.in28minutes.jpa.jpademo.inheritence.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
	public FullTimeEmployee(){}
	
	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	protected BigDecimal salary;
}