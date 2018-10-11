package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IProductInfoDAO;
import com.example.demo.repository.entity.ProductInfo;
import com.example.demo.service.IProductInfoService;

@Service
@Transactional
public class ProductInfoService implements IProductInfoService {

	@Autowired
	private IProductInfoDAO productServiceDao;

	@Override
	public List<ProductInfo> findAll() throws Exception {
		return productServiceDao.findAll();
	}

	@Override
	public ProductInfo create(ProductInfo obj) throws Exception {
		return productServiceDao.save(obj);
	}

	@Override
	public ProductInfo findById(Long id) throws Exception {
		return productServiceDao.findById(id).get();
	}

	@Override
	public ProductInfo update(ProductInfo obj) throws Exception {
		return productServiceDao.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		productServiceDao.deleteById(id);
	}
}
