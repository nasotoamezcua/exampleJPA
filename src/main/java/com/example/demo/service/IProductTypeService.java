package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.entity.ProductType;

public interface IProductTypeService extends CRUD<ProductType, Long>{
	
	List<ProductType> findAllLazyFetch();

}
