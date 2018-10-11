package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.ICustomerDAO;
import com.example.demo.repository.entity.Customer;
import com.example.demo.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDao;

	@Override
	public List<Customer> findAll() throws Exception {
		return customerDao.findAll();
	}

	@Override
	public Customer create(Customer obj) throws Exception {
		return customerDao.save(obj);
	}

	@Override
	public Customer findById(Long id) throws Exception {
		return customerDao.findById(id).get();
	}

	@Override
	public Customer update(Customer obj) throws Exception {
		return customerDao.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		customerDao.deleteById(id);
		
	}

}
