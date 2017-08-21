package com.in28minutes.jpa.jpademo.relationships.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "1=1")
public class Passport {

	protected Passport() {
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	@Id
	@GeneratedValue
	protected Long id;

	@NotNull
	protected String number;

	// Inverse Relationship
	// bi-directional OneToOne relationship
	// Column will not be created in the table
	// Try removing mappedBy = "passport" => You will see a student_id column
	// will be created in passport
	// @OneToOne
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	protected Student student;

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
