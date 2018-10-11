package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.Order;

public interface IOrderDAO extends JpaRepository<Order, Long> {

}
