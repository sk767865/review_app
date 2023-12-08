package com.nagarro.product.community.api.service;

import java.util.List;

import com.nagarro.product.community.api.dto.ProductSearchCriteria;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.exceptions.EmptySearchCriteriasException;
import com.nagarro.product.community.api.exceptions.ProductFoundException;
import com.nagarro.product.community.api.exceptions.ProductNotFoundException;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId) throws ProductNotFoundException;
	
	public Product getProductByProductCode(String productCode);
	
	public List<Product> getProductsBySearchCriteria(ProductSearchCriteria productSearchCriteria) throws EmptySearchCriteriasException;

	public Product addProduct(Product product) throws ProductFoundException;
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Long productId);
	
	public long getNumberOfProducts();
	
}
