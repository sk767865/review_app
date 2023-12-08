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

import com.nagarro.product.community.api.dto.ProductRequest;
import com.nagarro.product.community.api.dto.ProductResponse;
import com.nagarro.product.community.api.dto.ProductSearchCriteria;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.exceptions.EmptySearchCriteriasException;
import com.nagarro.product.community.api.exceptions.ProductFoundException;
import com.nagarro.product.community.api.exceptions.ProductNotFoundException;
import com.nagarro.product.community.api.exceptions.UserNotFoundException;
import com.nagarro.product.community.api.mapper.ProductMapper;
import com.nagarro.product.community.api.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMapper productMapper;
	
	@PostMapping()
	public Product addProduct(@RequestBody ProductRequest productRequest) throws UserNotFoundException, ProductFoundException {
		Product product = productMapper.productRequestMapper(productRequest);
		return productService.addProduct(product);
	}
	
	@GetMapping()
	public List<ProductResponse> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		List<ProductResponse> productResponses = new ArrayList<>();
		for(Product product:products) {
			productResponses.add(productMapper.productResponseMapper(product));
		}
		return productResponses;
	}
	
	@GetMapping("/byCode/{productCode}")
	public ProductResponse getProductByCode(@PathVariable("productCode") String productCode) {
		Product product = productService.getProductByProductCode(productCode);
		return productMapper.productResponseMapper(product);
	}

	@PostMapping("/criteria")
	public List<ProductResponse> getProductsBySearchCriteria(@RequestBody ProductSearchCriteria productSearchCriteria) throws EmptySearchCriteriasException{
		List<Product> products = productService.getProductsBySearchCriteria(productSearchCriteria);
		List<ProductResponse> productResponses = new ArrayList<>();
		for(Product product:products) {
			productResponses.add(productMapper.productResponseMapper(product));
		}
		return productResponses;
	}
	
	@GetMapping("/{productId}")
	public ProductResponse getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		Product product = productService.getProductById(productId);
		return productMapper.productResponseMapper(product);
	}
	
	@PutMapping()
	public Product updateProduct(@RequestBody ProductRequest productRequest) throws UserNotFoundException {
		Product product = productMapper.productRequestMapper(productRequest);
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
	}
	
}
