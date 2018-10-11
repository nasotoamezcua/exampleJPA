package com.example.demo.repository.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "DEMO_PRODUCT_INFO")
public class ProductInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEMO_PRODUCT_INFO_SEQ" )//Oracle
	@SequenceGenerator(sequenceName="DEMO_PRODUCT_INFO_SEQ", allocationSize=1,name="DEMO_PRODUCT_INFO_SEQ")//Oracle
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "PRODUCT_AVAIL")
	private String productAvail;
	
	@Column(name = "LIST_PRICE")
	private Integer listPrice;
	
	//NO SE GENERA GET NI SET Y SE EXCLUYE DEL toString(), hashCode() y equals() 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productInfo")
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	public ProductInfo() {}

	public ProductInfo(Long id, String productName, String productDescription, String category, String productAvail,
			Integer listPrice, Set<OrderItems> orderItems) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
		this.productAvail = productAvail;
		this.listPrice = listPrice;
		this.orderItems = orderItems;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getListPrice() {
		return listPrice;
	}

	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listPrice == null) ? 0 : listPrice.hashCode());
		result = prime * result + ((productAvail == null) ? 0 : productAvail.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		ProductInfo other = (ProductInfo) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listPrice == null) {
			if (other.listPrice != null)
				return false;
		} else if (!listPrice.equals(other.listPrice))
			return false;
		if (productAvail == null) {
			if (other.productAvail != null)
				return false;
		} else if (!productAvail.equals(other.productAvail))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", category=" + category + ", productAvail=" + productAvail + ", listPrice=" + listPrice + "]";
	}

}
