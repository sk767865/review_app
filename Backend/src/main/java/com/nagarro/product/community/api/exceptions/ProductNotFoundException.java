package com.nagarro.product.community.api.exceptions;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super("Product Not found.");
	}

	public ProductNotFoundException(Long productId) {
		super("Product Not found with id: " + productId);
	}

	
}
