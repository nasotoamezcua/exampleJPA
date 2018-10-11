package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IUserDAO;
import com.example.demo.repository.entity.User;
import com.example.demo.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDao;

	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}

	@Override
	public User create(User obj) throws Exception {
		return userDao.save(obj);
	}

	@Override
	public User findById(Long id) throws Exception {
		return userDao.findById(id).get();
	}

	@Override
	public User update(User obj) throws Exception {
		return userDao.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		userDao.deleteById(id);
	}

}
