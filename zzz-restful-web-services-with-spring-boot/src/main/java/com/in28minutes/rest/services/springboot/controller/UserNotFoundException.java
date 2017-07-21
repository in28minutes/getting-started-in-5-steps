package com.in28minutes.rest.services.springboot.controller;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 389949206272875015L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}