package com.nagarro.product.community.api.dto;

import com.nagarro.product.community.api.entity.User;

public class ProductResponse {

	private Long productId;

	private String productCode;

	private String productBrand;

	private String productName;

	private String productImage;
	
	private User user;
	
	private Integer numberOfReviews;
	
	private Float averageRating;
	
	public ProductResponse(){}

	public ProductResponse(String productCode, String productBrand, String productName, String productImage, User user,
			Integer numberOfReviews, Float averageRating) {
		super();
		this.productCode = productCode;
		this.productBrand = productBrand;
		this.productName = productName;
		this.productImage = productImage;
		this.user = user;
		this.numberOfReviews = numberOfReviews;
		this.averageRating = averageRating;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public Float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}
	
}
