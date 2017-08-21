package com.in28minutes.jpa.jpademo.relationships.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE student SET state = 'DELETED' WHERE id = ?")
public class Student {

	private Student() {
	}

	public Student(String name, StudentType studentType) {
		super();
		this.name = name;
		this.studentType = studentType;
	}

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	@OneToOne(fetch = FetchType.LAZY)
	protected Passport passport;

	// @ManyToMany
	@ManyToMany(mappedBy = "students")
	protected List<Course> courses = new ArrayList<>();

	// @Enumerated
	@Enumerated(EnumType.STRING)
	private StudentType studentType;

	@ElementCollection
	@CollectionTable(name = "STUDENT_PHONE")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHONE_TYPE")
	@Column(name = "PHONE_NUM")
	private Map<PhoneType, String> phoneNumbers;

	enum PhoneType {
		Home, Mobile, Work
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public StudentType getStudentType() {
		return studentType;
	}

	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void addPhoneNumber(PhoneType phoneType, String number) {
		phoneNumbers.put(phoneType, number);
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}

}
