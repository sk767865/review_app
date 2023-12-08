package com.nagarro.product.community.api.exceptions;

public class ProductFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductFoundException() {
		super("Product already exits.");
	}

	public ProductFoundException(String productId) {
		super("Product already exists with id: " + productId);
	}
	
}
