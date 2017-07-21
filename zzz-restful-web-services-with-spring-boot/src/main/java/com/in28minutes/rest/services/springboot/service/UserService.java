package com.in28minutes.rest.services.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.services.springboot.bean.User;

@Service
public class UserService implements UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 3;

	static {
		users.add(new User(1, "Alice", new Date()));
		users.add(new User(2, "Bob", new Date()));
		users.add(new User(3, "Charlie", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}
}