package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.Customer;

public interface ICustomerDAO extends JpaRepository<Customer, Long>{

}
