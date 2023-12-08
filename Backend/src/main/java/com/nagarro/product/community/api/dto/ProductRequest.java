package com.nagarro.product.community.api.dto;

public class ProductRequest {

	private Long productId;

	private String productCode;

	private String productBrand;

	private String productName;

	private String productImage;
	
	private String username;
	
	public ProductRequest() {}

	public ProductRequest(String productCode, String productBrand, String productName, String productImage,
			String username) {
		super();
		this.productCode = productCode;
		this.productBrand = productBrand;
		this.productName = productName;
		this.productImage = productImage;
		this.username = username;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
