package com.nagarro.product.community.api.exceptions;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User already exists.");
	}

	public UserFoundException(String msg) {
		super(msg);
	}

}
