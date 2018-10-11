package com.example.demo.service;

import java.util.List;

public interface CRUD<T,ID> {

	List<T> findAll() throws Exception;

	T create(T obj) throws Exception;

	T findById(ID id) throws Exception;
	
	T update(T obj) throws Exception;

	void deleteById(ID id) throws Exception;

}
