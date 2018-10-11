package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO {
	
	private Long idOrder;
	private Integer orderTotal;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	private Date orderTimestamp;
	
	public OrderDTO(){}
	
	public OrderDTO(Long idOrder, Integer orderTotal, Date orderTimestamp) {
		super();
		this.idOrder = idOrder;
		this.orderTotal = orderTotal;
		this.orderTimestamp = orderTimestamp;
	}


	
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
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
}
