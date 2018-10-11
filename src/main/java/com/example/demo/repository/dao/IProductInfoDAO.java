package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.ProductInfo;

public interface IProductInfoDAO extends JpaRepository<ProductInfo, Long> {

}
