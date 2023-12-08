package com.nagarro.product.community.api.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;
	
	private Float reviewRating;
	
	private String reviewHeading;
	
	@Lob
	private String reviewDescription;
	
	private Boolean isApproved = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private Product product;
	
	public Review() {}

	public Review(Float reviewRating, String reviewHeading, String reviewDescription, Boolean isApproved) {
		super();
		this.reviewRating = reviewRating;
		this.reviewHeading = reviewHeading;
		this.reviewDescription = reviewDescription;
		this.isApproved = isApproved;
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
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
