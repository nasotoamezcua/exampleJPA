package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IProductDAO;
import com.example.demo.repository.entity.Product;
import com.example.demo.service.IProductService;

@Service
@Transactional
public class ProductService implements IProductService {
	
	@Autowired
	IProductDAO productDAO;

	@Override
	public List<Product> findAll() throws Exception {
		return productDAO.findAll();
	}

	@Override
	public Product create(Product obj) throws Exception {
		return productDAO.save(obj);
	}

	@Override
	public Product findById(Long id) throws Exception {
		return productDAO.findById(id).get();
	}

	@Override
	public Product update(Product obj) throws Exception {
		return productDAO.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		productDAO.deleteById(id);
	}

	@Override
	public List<Product> findAllLazyFetch() {
		return productDAO.findAllLazyFetch();
	}

}
