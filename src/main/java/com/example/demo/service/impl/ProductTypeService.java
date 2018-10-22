package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IProductTypeDAO;
import com.example.demo.repository.entity.ProductType;
import com.example.demo.service.IProductTypeService;

@Service
@Transactional
public class ProductTypeService implements IProductTypeService{
	
	@Autowired
	IProductTypeDAO productTypeDAO;

	@Override
	public List<ProductType> findAll() throws Exception {
		return productTypeDAO.findAll();
	}

	@Override
	public ProductType create(ProductType obj) throws Exception {
		return productTypeDAO.save(obj);
	}

	@Override
	public ProductType findById(Long id) throws Exception {
		return productTypeDAO.findById(id).get();
	}

	@Override
	public ProductType update(ProductType obj) throws Exception {
		return productTypeDAO.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		productTypeDAO.deleteById(id);
	}

	@Override
	public List<ProductType> findAllLazyFetch() {
		return productTypeDAO.findAllLazyFetch();
	}

}
