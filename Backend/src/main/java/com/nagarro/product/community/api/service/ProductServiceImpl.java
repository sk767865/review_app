package com.nagarro.product.community.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.product.community.api.dao.ProductDao;
import com.nagarro.product.community.api.dto.ProductSearchCriteria;
import com.nagarro.product.community.api.entity.Product;
import com.nagarro.product.community.api.exceptions.EmptySearchCriteriasException;
import com.nagarro.product.community.api.exceptions.ProductFoundException;
import com.nagarro.product.community.api.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getProductById(Long productId) throws ProductNotFoundException {
		return productDao.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
	}

	@Override
	public Product getProductByProductCode(String productCode) {
		return productDao.findByProductCode(productCode).get(0);
	}

	@Override
	public List<Product> getProductsBySearchCriteria(ProductSearchCriteria productSearchCriteria) throws EmptySearchCriteriasException {
		
		if((productSearchCriteria.getProductCode() != null && productSearchCriteria.getProductCode() != "")
				&& (productSearchCriteria.getProductBrand() != null && productSearchCriteria.getProductBrand() != "")
				&& (productSearchCriteria.getProductName() != null && productSearchCriteria.getProductName() != "")) {
			return productDao.findByProductCodeAndProductBrandAndProductName(productSearchCriteria.getProductCode(), productSearchCriteria.getProductBrand(), productSearchCriteria.getProductName());
		} else if((productSearchCriteria.getProductCode() != null && productSearchCriteria.getProductCode() != "")
				&& (productSearchCriteria.getProductBrand() != null && productSearchCriteria.getProductBrand() != "")) {
			return productDao.findByProductCodeAndProductBrand(productSearchCriteria.getProductCode(), productSearchCriteria.getProductBrand());
		} else if((productSearchCriteria.getProductCode() != null && productSearchCriteria.getProductCode() != "")
				&& (productSearchCriteria.getProductName() != null && productSearchCriteria.getProductName() != "")) {
			return productDao.findByProductCodeAndProductName(productSearchCriteria.getProductCode(), productSearchCriteria.getProductName());
		} else if((productSearchCriteria.getProductBrand() != null && productSearchCriteria.getProductBrand() != "")
				&& (productSearchCriteria.getProductName() != null && productSearchCriteria.getProductName() != "")) {
			return productDao.findByProductBrandAndProductName(productSearchCriteria.getProductBrand(), productSearchCriteria.getProductName());
			} else if((productSearchCriteria.getProductCode() != null && productSearchCriteria.getProductCode() != "")) {
				return productDao.findByProductCode(productSearchCriteria.getProductCode());
			} else if((productSearchCriteria.getProductBrand() != null && productSearchCriteria.getProductBrand() != "")) {
				return productDao.findByProductBrand(productSearchCriteria.getProductBrand());
			} else if((productSearchCriteria.getProductName() != null && productSearchCriteria.getProductName() != "")){
				return productDao.findByProductName(productSearchCriteria.getProductName());
			} else {
				throw new EmptySearchCriteriasException("All Search Criterias cannot be empty");
			}
		
		}


	@Override
	public Product addProduct(Product product) throws ProductFoundException {
		if(productDao.findByProductCode(product.getProductCode()).size() != 0) {
			throw new ProductFoundException(product.getProductCode());
		}
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = new Product();
		product.setProductId(productId);
		productDao.delete(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public long getNumberOfProducts() {
		return productDao.count();
	}

}
