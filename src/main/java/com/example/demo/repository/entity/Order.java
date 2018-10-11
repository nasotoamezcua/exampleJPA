package com.example.demo.repository.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "DEMO_ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEMO_ORDERS_SEQ" )//Oracle
	@SequenceGenerator(sequenceName="DEMO_ORDERS_SEQ", allocationSize=1,name="DEMO_ORDERS_SEQ")//Oracle
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long id;
	
	@Column(name= "ORDER_TOTAL")
	private Integer orderTotal;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	@Column(name="ORDER_TIMESTAMP")
	private Date orderTimestamp;
	
	//SOLO SE GENERA EL SET y SE EXCLUYE DEL toString(), hashCode() y equals() 
	//SIEMPRE QUE SE UTILIZA FetchType.LAZY LA PROPIEDAD NO DEBE DE TENER GET
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	//SOLO SE GENERA EL SET y SE EXCLUYE DEL toString(), hashCode() y equals() 
	//SIEMPRE QUE SE UTILIZA FetchType.LAZY LA PROPIEDAD NO DEBE DE TENER GET
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	//NO SE GENERA GET NI SET Y SE EXCLUYE DEL toString(), hashCode() y equals()
	//SIEMPRE QUE SE UTILIZA FetchType.LAZY EN UNA LISTA LA PROPIEDAD NO DEBE DE TENER GET NI SET
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = {CascadeType.ALL})
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	public Order() {}

	public Order(Long id, Integer orderTotal, Date orderTimestamp, Customer customer, User user,
			Set<OrderItems> orderItems) {
		super();
		this.id = id;
		this.orderTotal = orderTotal;
		this.orderTimestamp = orderTimestamp;
		this.customer = customer;
		this.user = user;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTotal=" + orderTotal + ", orderTimestamp=" + orderTimestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderTimestamp == null) ? 0 : orderTimestamp.hashCode());
		result = prime * result + ((orderTotal == null) ? 0 : orderTotal.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderTimestamp == null) {
			if (other.orderTimestamp != null)
				return false;
		} else if (!orderTimestamp.equals(other.orderTimestamp))
			return false;
		if (orderTotal == null) {
			if (other.orderTotal != null)
				return false;
		} else if (!orderTotal.equals(other.orderTotal))
			return false;
		return true;
	}
	
	
	
	
}
