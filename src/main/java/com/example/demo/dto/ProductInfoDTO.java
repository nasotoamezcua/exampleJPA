package com.example.demo.dto;

public class ProductInfoDTO {
	
	private Long idProductInfo;
	private String productName;
	private String productDescription;
	private String category;
	private String productAvail;
	
	public ProductInfoDTO(){}
	
	public ProductInfoDTO(Long idProductInfo, String productName, String productDescription, String category,
			String productAvail) {
		super();
		this.idProductInfo = idProductInfo;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
		this.productAvail = productAvail;
	}

	public Long getIdProductInfo() {
		return idProductInfo;
	}
	public void setIdProductInfo(Long idProductInfo) {
		this.idProductInfo = idProductInfo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductAvail() {
		return productAvail;
	}
	public void setProductAvail(String productAvail) {
		this.productAvail = productAvail;
	}
}
