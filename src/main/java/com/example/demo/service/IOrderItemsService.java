package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.entity.OrderItems;

public interface IOrderItemsService extends CRUD<OrderItems, Long>{
	
	List<OrderItems> findByOrderId(Long id);

}
