package com.nagarro.product.community.api.exceptions;

public class ProductCommunityApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductCommunityApiException(String exMessage, Exception exception) {
		super(exMessage, exception);
	}

	public ProductCommunityApiException(String exMessage) {
		super(exMessage);
	}
}
