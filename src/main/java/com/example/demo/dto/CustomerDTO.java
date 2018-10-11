package com.example.demo.dto;

public class CustomerDTO {
	
	private Long idCustomer;
	private String custFirstName;
	private String custLastName;
	private String custStreetName;
	private String custCity;
	private String custState;
	private String custPostalCode;
	private String phoneNumber;
	private Integer creditLimit;
	
	public CustomerDTO() {}
	
	public CustomerDTO(Long idCustomer, String custFirstName, String custLastName, String custStreetName, String custCity,
			String custState, String custPostalCode, String phoneNumber, Integer creditLimit) {
		super();
		this.idCustomer = idCustomer;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custStreetName = custStreetName;
		this.custCity = custCity;
		this.custState = custState;
		this.custPostalCode = custPostalCode;
		this.phoneNumber = phoneNumber;
		this.creditLimit = creditLimit;
	}
	

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
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
}
