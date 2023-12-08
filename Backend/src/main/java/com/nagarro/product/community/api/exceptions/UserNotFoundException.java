package com.nagarro.product.community.api.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User does not exists.");
	}

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
}
