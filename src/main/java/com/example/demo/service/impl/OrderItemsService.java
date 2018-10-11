package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IOrderItemsDAO;
import com.example.demo.repository.entity.OrderItems;
import com.example.demo.service.IOrderItemsService;

@Service
@Transactional
public class OrderItemsService implements IOrderItemsService {
	
	@Autowired
	private IOrderItemsDAO orderItemDAO;

	@Override
	public List<OrderItems> findAll() throws Exception {
		return orderItemDAO.findAll();
	}

	@Override
	public OrderItems create(OrderItems obj) throws Exception {
		return orderItemDAO.save(obj);
	}

	@Override
	public OrderItems findById(Long id) throws Exception {
		return orderItemDAO.findById(id).get();
	}

	@Override
	public OrderItems update(OrderItems obj) throws Exception {
		return  orderItemDAO.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		orderItemDAO.deleteById(id);
	}

	@Override
	public List<OrderItems> findByOrderId(Long id) {
		return orderItemDAO.findByOrderId(id);
	}

}
