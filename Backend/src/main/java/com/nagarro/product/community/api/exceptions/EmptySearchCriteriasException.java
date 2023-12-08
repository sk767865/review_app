package com.nagarro.product.community.api.exceptions;

public class EmptySearchCriteriasException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptySearchCriteriasException() {
		super("All Search Criterias cannot be empty");
	}

	public EmptySearchCriteriasException(String msg) {
		super(msg);
	}
	
}
