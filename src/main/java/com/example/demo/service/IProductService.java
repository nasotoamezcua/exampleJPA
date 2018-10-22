package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.entity.Product;

public interface IProductService extends CRUD<Product, Long>{
	
	List<Product> findAllLazyFetch();

}
