package com.in28minutes.rest.services.springboot.service;

import java.util.List;

import com.in28minutes.rest.services.springboot.bean.User;

public interface UserDaoService {
	public List<User> findAll();

	public User save(User user);

	public User findOne(int id);
}
