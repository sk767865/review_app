package com.nagarro.product.community.api.dto;

public class ProductSearchCriteria {

	private String productCode;
	
	private String productBrand;
	
	private String productName;
	
	public ProductSearchCriteria(){}

	public ProductSearchCriteria(String productCode, String productBrand, String productName) {
		super();
		this.productCode = productCode;
		this.productBrand = productBrand;
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
