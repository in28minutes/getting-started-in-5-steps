package com.in28minutes.jpa.jpademo.relationships.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")
@NamedQuery(query = "select c from Course c", name = "QUERY_ALL_COURSES")
@NamedEntityGraph(name = "graph.CourseAndStudents", 
attributeNodes = @NamedAttributeNode(value = "students"/*, subgraph = "students"),*/)
/*subgraphs = @NamedSubgraph(name = "students", attributeNodes = @NamedAttributeNode("passport"))*/)
@Cacheable
public class Course {

	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	// @OneToMany
	@OneToMany(mappedBy = "course")
	protected List<Review> reviews = new ArrayList<>();

	@ManyToMany
	// @JoinTable(name = "COURSE_STUDENT",
	// joinColumns = @JoinColumn(name = "COURSE_ID"),
	// inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	protected List<Student> students = new ArrayList<>();

	@CreationTimestamp
	private LocalDateTime createDateTime;

	private LocalDate activeFrom;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public LocalDate getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(LocalDate activeFrom) {
		this.activeFrom = activeFrom;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}

}
