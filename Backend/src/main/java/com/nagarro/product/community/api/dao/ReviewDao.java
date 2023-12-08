package com.nagarro.product.community.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {

	public List<Review> findByProductAndIsApproved(Product product, Boolean isApproved);
	
	public List<Review> findByIsApproved(Boolean isApproved);
	
	public long countByIsApproved(Boolean isApproved);
	
}
