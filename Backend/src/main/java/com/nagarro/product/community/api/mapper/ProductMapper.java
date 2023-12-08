package com.nagarro.product.community.api.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.product.community.api.dto.ProductRequest;
import com.nagarro.product.community.api.dto.ProductResponse;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.entity.Review;
import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.exceptions.UserNotFoundException;
import com.nagarro.product.community.api.service.ReviewServiceImpl;
import com.nagarro.product.community.api.service.UserServiceImpl;

@Component
public class ProductMapper {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ReviewServiceImpl reviewServiceImpl;
	
	public Product productRequestMapper(ProductRequest productRequest) throws UserNotFoundException {
		Product product = new Product();
		
		product.setProductId(productRequest.getProductId());
		product.setProductCode(productRequest.getProductCode());
		product.setProductBrand(productRequest.getProductBrand());
		product.setProductName(productRequest.getProductName());
		product.setProductImage(productRequest.getProductImage());
		
		User user = userServiceImpl.getUser(productRequest.getUsername());
		
		product.setUser(user);
		
		return product;
	}
	
	public ProductResponse productResponseMapper(Product product) {
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setProductId(product.getProductId());
		productResponse.setProductCode(product.getProductCode());
		productResponse.setProductBrand(product.getProductBrand());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductImage(product.getProductImage());
		productResponse.setUser(product.getUser());
		
		List<Review> reviews = reviewServiceImpl.getAllApprovedReviewsOfProduct(product);
		
		int numberOfReviews = reviews.size();
				
		productResponse.setNumberOfReviews(numberOfReviews);
		
		
		float ratingSumOfApproved = 0;
		for(Review r : reviews) {
			if(r.getIsApproved()) {
				ratingSumOfApproved += r.getReviewRating();
			}
		}
		
		float averageRating = ratingSumOfApproved;
		
		if(productResponse.getNumberOfReviews()!=0) {
		averageRating = ratingSumOfApproved/(productResponse.getNumberOfReviews());
		}
		productResponse.setAverageRating(averageRating);
		
		
		return productResponse;
	}
	
}
