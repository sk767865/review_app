package com.nagarro.product.community.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.product.community.api.dto.ReviewRequest;
import com.nagarro.product.community.api.dto.ReviewResponse;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;
import com.nagarro.product.community.api.exceptions.ProductNotFoundException;
import com.nagarro.product.community.api.exceptions.UserNotFoundException;
import com.nagarro.product.community.api.mapper.ReviewMapper;
import com.nagarro.product.community.api.service.ReviewServiceImpl;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	private ReviewServiceImpl reviewServiceImpl;
	@Autowired
	private ReviewMapper reviewMapper;
	
	@PostMapping()
	public Review addReview(@RequestBody ReviewRequest reviewRequest) throws UserNotFoundException, ProductNotFoundException {
		Review review = reviewMapper.reviewRequestMapper(reviewRequest);
		return reviewServiceImpl.addReview(review);
	}
	
	@PutMapping()
	public Review updateReview(@RequestBody ReviewRequest reviewRequest) throws UserNotFoundException, ProductNotFoundException {
		Review review = reviewMapper.reviewRequestMapper(reviewRequest);
		return reviewServiceImpl.updateReview(review);
	}
	
	@GetMapping("/{productId}")
	public List<ReviewResponse> getAllApprovedReviewsOfProduct(@PathVariable("productId") Long productId){
		Product product = new Product();
		product.setProductId(productId);
		List<Review> reviews = reviewServiceImpl.getAllApprovedReviewsOfProduct(product);
		List<ReviewResponse> reviewsResponse = new ArrayList<>();
		for(Review review:reviews) {
			reviewsResponse.add(reviewMapper.reviewResponseMapper(review));
		}
		return reviewsResponse;
	}
	
	@GetMapping("/pending")
	public List<ReviewResponse> getAllPendigReviews(){
		List<Review> reviews = reviewServiceImpl.getAllPendingReviews();
		List<ReviewResponse> reviewsResponse = new ArrayList<>();
		for(Review review:reviews) {
			reviewsResponse.add(reviewMapper.reviewResponseMapper(review));
		}
		return reviewsResponse;
	}
	
	@DeleteMapping("/{reviewId}")
	public void deleteReview(@PathVariable("reviewId") Long reviewId) {
		reviewServiceImpl.deleteReview(reviewId);
	}
	
}
