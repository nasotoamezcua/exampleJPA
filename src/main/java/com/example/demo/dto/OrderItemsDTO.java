package com.example.demo.dto;

public class OrderItemsDTO {
		
	private Long idOrderItem;
	private Integer quantity;
	private Integer unitPrice;
	
	public OrderItemsDTO() {}

	public OrderItemsDTO(Long idOrderItem, Integer quantity, Integer unitPrice) {
		super();
		this.idOrderItem = idOrderItem;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
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
	
	
	
}
