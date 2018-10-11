package com.example.demo.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_ORDER_ITEMS")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEMO_ORDER_ITEMS_SEQ" )//Oracle
	@SequenceGenerator(sequenceName="DEMO_ORDER_ITEMS_SEQ", allocationSize=1,name="DEMO_ORDER_ITEMS_SEQ")//Oracle
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	
	@Column(name = "UNIT_PRICE")
	private Integer unitPrice;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	//SOLO SE GENERA EL SET  y SE EXCLUYE DEL toString(), hashCode() y equals()
	//SIEMPRE QUE SE UTILIZA FetchType.LAZY LA PROPIEDAD NO DEBE DE TENER GET
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	//SOLO SE GENERA EL SET  y SE EXCLUYE DEL toString(), hashCode() y equals()
	//SIEMPRE QUE SE UTILIZA FetchType.LAZY LA PROPIEDAD NO DEBE DE TENER GET
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT_ID")
	private ProductInfo productInfo;

	public OrderItems() {}

	public OrderItems(Long id, Integer unitPrice, Integer quantity, Order order, ProductInfo productInfo) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.order = order;
		this.productInfo = productInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		OrderItems other = (OrderItems) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
	
	
	
}
