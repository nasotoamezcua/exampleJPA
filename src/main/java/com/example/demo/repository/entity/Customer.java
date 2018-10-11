package com.example.demo.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_CUSTOMERS")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEMO_CUSTOMERS_SEQ" )//Oracle
	@SequenceGenerator(sequenceName="DEMO_CUSTOMERS_SEQ", allocationSize=1,name="DEMO_CUSTOMERS_SEQ")//Oracle
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Long id;
	
	@Column(name = "CUST_FIRST_NAME")
	private String custFirstName;
	
	@Column(name = "CUST_LAST_NAME")
	private String custLastName;
	
	@Column(name = "CUST_STREET_ADDRESS1")
	private String custStreetName;
	
	@Column(name = "CUST_CITY")
	private String custCity;
	
	@Column(name = "CUST_STATE")
	private String custState;
	
	@Column(name = "CUST_POSTAL_CODE")
	private String custPostalCode;
	
	@Column(name = "PHONE_NUMBER1")
	private String phoneNumber;
	
	@Column(name = "CREDIT_LIMIT")
	private Integer creditLimit;
	
	
	//NO SE GENERA GET NI SET Y SE EXCLUYE DEL toString(), hashCode() y equals() 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE)
	private Set<Order> orders = new HashSet<Order>();
	
	public Customer() {}
			
	public Customer(Long id, String custFirstName, String custLastName, String custStreetName, String custCity,
			String custState, String custPostalCode, String phoneNumber, Integer creditLimit, Set<Order> orders) {
		
		super();
		this.id = id;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custStreetName = custStreetName;
		this.custCity = custCity;
		this.custState = custState;
		this.custPostalCode = custPostalCode;
		this.phoneNumber = phoneNumber;
		this.creditLimit = creditLimit;
		this.orders = orders;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custFirstName=" + custFirstName + ", custLastName=" + custLastName
				+ ", custStreetName=" + custStreetName + ", custCity=" + custCity + ", custState=" + custState
				+ ", custPostalCode=" + custPostalCode + ", phoneNumber=" + phoneNumber + ", creditLimit=" + creditLimit
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditLimit == null) ? 0 : creditLimit.hashCode());
		result = prime * result + ((custCity == null) ? 0 : custCity.hashCode());
		result = prime * result + ((custFirstName == null) ? 0 : custFirstName.hashCode());
		result = prime * result + ((custLastName == null) ? 0 : custLastName.hashCode());
		result = prime * result + ((custPostalCode == null) ? 0 : custPostalCode.hashCode());
		result = prime * result + ((custState == null) ? 0 : custState.hashCode());
		result = prime * result + ((custStreetName == null) ? 0 : custStreetName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (creditLimit == null) {
			if (other.creditLimit != null)
				return false;
		} else if (!creditLimit.equals(other.creditLimit))
			return false;
		if (custCity == null) {
			if (other.custCity != null)
				return false;
		} else if (!custCity.equals(other.custCity))
			return false;
		if (custFirstName == null) {
			if (other.custFirstName != null)
				return false;
		} else if (!custFirstName.equals(other.custFirstName))
			return false;
		if (custLastName == null) {
			if (other.custLastName != null)
				return false;
		} else if (!custLastName.equals(other.custLastName))
			return false;
		if (custPostalCode == null) {
			if (other.custPostalCode != null)
				return false;
		} else if (!custPostalCode.equals(other.custPostalCode))
			return false;
		if (custState == null) {
			if (other.custState != null)
				return false;
		} else if (!custState.equals(other.custState))
			return false;
		if (custStreetName == null) {
			if (other.custStreetName != null)
				return false;
		} else if (!custStreetName.equals(other.custStreetName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

}
