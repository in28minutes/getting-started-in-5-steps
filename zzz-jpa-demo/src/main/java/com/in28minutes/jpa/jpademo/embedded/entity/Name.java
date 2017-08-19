package com.in28minutes.jpa.jpademo.embedded.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Embeddable
public class Name {
	
	@Id
	@GeneratedValue
	protected Long id;
	protected String firstName;
	protected String middleName;
	protected String lastName;
}
