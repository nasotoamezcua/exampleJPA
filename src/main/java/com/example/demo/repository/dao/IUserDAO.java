package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.entity.User;

public interface IUserDAO extends JpaRepository<User, Long> {

}
