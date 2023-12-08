package com.nagarro.product.community.api.dto;

import com.nagarro.product.community.api.entity.User;

public class ReviewResponse {

	private Long reviewId;

	private Float reviewRating;

	private String reviewHeading;

	private String reviewDescription;
	
	private Boolean isApproved;

	private User user;

	private Long productId;
	
	public ReviewResponse() {}

	public ReviewResponse(Float reviewRating, String reviewHeading, String reviewDescription, Boolean isApproved,
			com.nagarro.product.community.api.entity.User user, Long productId) {
		super();
		this.reviewRating = reviewRating;
		this.reviewHeading = reviewHeading;
		this.reviewDescription = reviewDescription;
		this.isApproved = isApproved;
		this.user = user;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
