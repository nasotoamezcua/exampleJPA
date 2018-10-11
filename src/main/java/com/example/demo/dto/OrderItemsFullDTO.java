package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderItemsFullDTO {
	
	// ORDER
	private Long id_order;
	private Integer orderTotal;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	private Date orderTimestamp;
	
	//PRODUCT INFO
	List<OrderItemsProductInfoDTO> orderItemsProductInfoDTO;
	
	// ORDER ITEM
	private Integer quantity;
	private Integer unitPrice;
	
	//CUSTOMER
	private Long id_customer;	
	private String custFirstName;
	private String custLastName;
	private String custStreetName;
	private String custCity;
	private String custState;
	private String custPostalCode;
	private String phoneNumber;
	private Integer creditLimit;
	
	//USER
	private Long id_user;
	private String userName;
	private String password;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	private Date createOn;
	
	
	public Long getId_order() {
		return id_order;
	}
	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}
	public Integer getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Date getOrderTimestamp() {
		return orderTimestamp;
	}
	public void setOrderTimestamp(Date orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}
	
	public List<OrderItemsProductInfoDTO> getOrderItemsProductInfoDTO() {
		return orderItemsProductInfoDTO;
	}
	public void setOrderItemsProductInfoDTO(List<OrderItemsProductInfoDTO> orderItemsProductInfoDTO) {
		this.orderItemsProductInfoDTO = orderItemsProductInfoDTO;
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
	public Long getId_customer() {
		return id_customer;
	}
	public void setId_customer(Long id_customer) {
		this.id_customer = id_customer;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getCustStreetName() {
		return custStreetName;
	}
	public void setCustStreetName(String custStreetName) {
		this.custStreetName = custStreetName;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = custState;
	}
	public String getCustPostalCode() {
		return custPostalCode;
	}
	public void setCustPostalCode(String custPostalCode) {
		this.custPostalCode = custPostalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
}
