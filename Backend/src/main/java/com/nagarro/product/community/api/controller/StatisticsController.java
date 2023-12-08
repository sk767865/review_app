package com.nagarro.product.community.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.product.community.api.service.ProductServiceImpl;
import com.nagarro.product.community.api.service.ReviewServiceImpl;
import com.nagarro.product.community.api.service.UserServiceImpl;

@RestController
@RequestMapping("/stats")
@CrossOrigin("*")
public class StatisticsController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private ReviewServiceImpl reviewServiceImpl;

	@GetMapping("/users")
	public long getNumberOfRegisteredUsers() {
		return userServiceImpl.getNumberOfUsers();
	}
	
	@GetMapping("/products")
	public long getNumberOfProducts() {
		return productServiceImpl.getNumberOfProducts();
	}
	
	@GetMapping("/reviews")
	public long getNumberOfReviews() {
		return reviewServiceImpl.getNumberOfReviews();
	}
	
}
