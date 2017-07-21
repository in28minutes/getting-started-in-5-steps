package com.in28minutes.rest.services.springboot.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp = new Date();
	private String message;
	private Object details;

	public ExceptionResponse(String message, Object details) {
		super();
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Object getDetails() {
		return details;
	}
}