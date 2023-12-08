package com.nagarro.product.community.api.service;

import java.util.List;

import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;

public interface ReviewService {
	
	public Review addReview(Review review);
	
	public Review updateReview(Review review);
	
	public List<Review> getAllApprovedReviewsOfProduct(Product product);
	
	public List<Review> getAllPendingReviews();
	
	public void deleteReview(Long reviewId);
	
	public long getNumberOfReviews();

}
