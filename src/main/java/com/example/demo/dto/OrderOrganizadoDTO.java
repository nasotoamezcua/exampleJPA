package com.example.demo.dto;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderOrganizadoDTO {
	
	private OrderDTO orderDto;
	
	//PRODUCT INFO
	private	List<OrderItemsProductInfoDTO> orderItemsProductInfoDTO;
	
//	@JsonIgnore
	private CustomerDTO customerDto;
//	@JsonIgnore
	private UserDTO userDto;
	
	public OrderOrganizadoDTO() {}

	public OrderOrganizadoDTO(OrderDTO orderDto, List<OrderItemsProductInfoDTO> orderItemsProductInfoDTO,
			CustomerDTO customerDto, UserDTO userDto) {
		super();
		this.orderDto = orderDto;
		this.orderItemsProductInfoDTO = orderItemsProductInfoDTO;
		this.customerDto = customerDto;
		this.userDto = userDto;
	}

	public OrderDTO getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDTO orderDto) {
		this.orderDto = orderDto;
	}

	public List<OrderItemsProductInfoDTO> getOrderItemsProductInfoDTO() {
		return orderItemsProductInfoDTO;
	}

	public void setOrderItemsProductInfoDTO(List<OrderItemsProductInfoDTO> orderItemsProductInfoDTO) {
		this.orderItemsProductInfoDTO = orderItemsProductInfoDTO;
	}

	public CustomerDTO getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDTO customerDto) {
		this.customerDto = customerDto;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	
}
