package com.example.demo.dto;

public class OrderItemsProductInfoDTO {
	
	//OrderItem
	private Long idOrderItem;
	private Integer quantity;
	private Integer unitPrice;
	//ProductInfo
	private Long idProductInfo;
	private String productName;
	private String productDescription;
	private String category;
	private String productAvail;
	
	public  OrderItemsProductInfoDTO() {}
	
	public OrderItemsProductInfoDTO(Long idOrderItem, Integer quantity, Integer unitPrice, Long idProductInfo,
			String productName, String productDescription, String category, String productAvail) {
		super();
		this.idOrderItem = idOrderItem;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.idProductInfo = idProductInfo;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
		this.productAvail = productAvail;
	}
	
	public Long getIdOrderItem() {
		return idOrderItem;
	}
	public void setIdOrderItem(Long idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
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
