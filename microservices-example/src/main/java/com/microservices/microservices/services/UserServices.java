package com.microservices.microservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.microservices.microservices.bean.User;
import com.microservices.microservices.exceptions.UserNotFoundException;

@Component
public class UserServices {

	private static List<User> users = new ArrayList<User>();

	private static int counter = 3;
	static {
		users.add(new User(1, "Rakesh Sahoo", new Date()));
		users.add(new User(2, "Saroj Kumar Sahoo", new Date()));
		users.add(new User(3, "Sunita Rani Sahoo", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			counter++;
			user.setId(counter);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		User user = null;
		if (users.stream().filter((i) -> i.getId() == id).collect(Collectors.toList()).size() > 0) {
			user = users.stream().filter((i) -> i.getId() == id).collect(Collectors.toList()).get(0);

		} else {
			throw new UserNotFoundException("ID " + id + " is not found.");
		}
		return user;
	}
	
	public User deleteById(int id)
	{
		User user = null;
		if(users.stream().filter((i) -> i.getId() == id).collect(Collectors.toList()).size() > 0)
		{
			user = users.stream().filter((i) -> i.getId() == id).collect(Collectors.toList()).get(0);
			users = users.stream().filter((i)-> i.getId() != id).collect(Collectors.toList());
		}
		else
		{
			throw new UserNotFoundException("ID " + id + " is not found.");
		}
		return user;
	}
}
