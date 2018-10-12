package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.Product;

public interface IProductDAO extends JpaRepository<Product, Long> {

}
