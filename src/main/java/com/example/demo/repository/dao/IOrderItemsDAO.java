package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.OrderItems;

public interface IOrderItemsDAO extends JpaRepository<OrderItems, Long>{
	
	List<OrderItems> findByOrderId(Long id);

}
