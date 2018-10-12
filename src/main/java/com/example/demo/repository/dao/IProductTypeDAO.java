package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.ProductType;

public interface IProductTypeDAO extends JpaRepository<ProductType, Long> {

}
