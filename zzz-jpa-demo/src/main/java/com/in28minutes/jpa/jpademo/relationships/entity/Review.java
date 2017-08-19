package com.in28minutes.jpa.jpademo.relationships.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	private Review() {}

	public Review(ReviewRating rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	@Id
	@GeneratedValue
	protected Long id;
	
	@Enumerated
	protected ReviewRating rating;
		
	protected String description;

	@ManyToOne
	// @JoinColumn(name="COURSE_ID")
	protected Course course;

	public Long getId() {
		return id;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
