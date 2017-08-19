
package com.in28minutes.jpa.jpademo.embedded.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne
	//@Embedded
	protected Name name;

}
