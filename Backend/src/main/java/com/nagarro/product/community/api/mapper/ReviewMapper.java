package com.nagarro.product.community.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.product.community.api.dto.ReviewRequest;
import com.nagarro.product.community.api.dto.ReviewResponse;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;
import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.exceptions.ProductNotFoundException;
import com.nagarro.product.community.api.exceptions.UserNotFoundException;
import com.nagarro.product.community.api.service.ProductServiceImpl;
import com.nagarro.product.community.api.service.UserServiceImpl;

@Component
public class ReviewMapper {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	public Review reviewRequestMapper(ReviewRequest reviewRequest) throws UserNotFoundException, ProductNotFoundException {
		Review review = new Review();
		review.setReviewId(reviewRequest.getReviewId());
		review.setReviewRating(reviewRequest.getReviewRating());
		review.setReviewHeading(reviewRequest.getReviewHeading());
		review.setReviewDescription(reviewRequest.getReviewDescription());
		if(reviewRequest.getIsApproved()!=null) {
		if(reviewRequest.getIsApproved()==true || reviewRequest.getIsApproved()==false) {
			review.setIsApproved(reviewRequest.getIsApproved());
		}
		}
		
		User user = userServiceImpl.getUser(reviewRequest.getUsername());
		Product product = productServiceImpl.getProductById(reviewRequest.getProductId());
		
		review.setUser(user);
		review.setProduct(product);
		
		return review;
	}
	
	public ReviewResponse reviewResponseMapper(Review review) {
		ReviewResponse reviewResponse = new ReviewResponse();
		
		reviewResponse.setReviewId(review.getReviewId());
		reviewResponse.setReviewRating(review.getReviewRating());
		reviewResponse.setReviewHeading(review.getReviewHeading());
		reviewResponse.setReviewDescription(review.getReviewDescription());
		reviewResponse.setIsApproved(review.getIsApproved());
		reviewResponse.setUser(review.getUser());
		reviewResponse.setProductId(review.getProduct().getProductId());
		
		return reviewResponse;
	}

}
