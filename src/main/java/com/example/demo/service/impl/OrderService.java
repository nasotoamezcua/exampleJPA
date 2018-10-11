package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IOrderDAO;
import com.example.demo.repository.entity.Order;
import com.example.demo.service.IOrderService;

@Service
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderDAO orderDao;

	@Override
	public List<Order> findAll() throws Exception {
		return orderDao.findAll();
	}

	@Override
	public Order create(Order obj) throws Exception {
		return orderDao.save(obj);
	}

	@Override
	public Order findById(Long id) throws Exception {
		return orderDao.findById(id).get();
	}

	@Override
	public Order update(Order obj) throws Exception {
		return orderDao.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		orderDao.deleteById(id);
		
	}

}
