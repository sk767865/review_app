package com.nagarro.product.community.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.product.community.api.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findByProductCode(String productCode);
	
	List<Product> findByProductBrand(String productBrand);
	
	List<Product> findByProductName(String productName);
	
	List<Product> findByProductCodeAndProductBrand(String productCode, String productBrand);
	
	List<Product> findByProductCodeAndProductName(String productCode, String productName);
	
	List<Product> findByProductBrandAndProductName(String productBrand, String productName);
	
	List<Product> findByProductCodeAndProductBrandAndProductName(String productCode, String productBrand, String prodcutName);
	
}
