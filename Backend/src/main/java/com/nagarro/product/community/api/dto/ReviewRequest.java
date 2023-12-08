package com.nagarro.product.community.api.dto;

public class ReviewRequest {

	private Long reviewId;

	private Float reviewRating;

	private String reviewHeading;

	private String reviewDescription;
	
	private Boolean isApproved;

	private String username;

	private Long productId;
	
	public ReviewRequest() {}

	public ReviewRequest(Float reviewRating, String reviewHeading, String reviewDescription, Boolean isApproved, String username,
			Long productId) {
		super();
		this.reviewRating = reviewRating;
		this.reviewHeading = reviewHeading;
		this.reviewDescription = reviewDescription;
		this.isApproved = isApproved;
		this.username = username;
		this.productId = productId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Float getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(Float reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getReviewHeading() {
		return reviewHeading;
	}

	public void setReviewHeading(String reviewHeading) {
		this.reviewHeading = reviewHeading;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}