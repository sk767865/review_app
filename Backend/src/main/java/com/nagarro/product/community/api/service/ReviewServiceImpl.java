package com.nagarro.product.community.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.product.community.api.dao.ReviewDao;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public Review addReview(Review review) {
		return reviewDao.save(review);
	}

	@Override
	public Review updateReview(Review review) {
		return reviewDao.save(review);
	}

	@Override
	public List<Review> getAllApprovedReviewsOfProduct(Product product) {
		return reviewDao.findByProductAndIsApproved(product, true);
	}
	
	@Override
	public List<Review> getAllPendingReviews() {
		return reviewDao.findByIsApproved(false);
	}

	@Override
	public void deleteReview(Long reviewId) {
		reviewDao.deleteById(reviewId);
	}

	@Override
	public long getNumberOfReviews() {
		return reviewDao.countByIsApproved(true);
	}

}
