package com.microservices.microservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.microservices.bean.User;
import com.microservices.microservices.services.UserServices;

@RestController
public class UserServiceController {

	@Autowired
	public UserServices userService;

	@GetMapping("/users")
	public List<User> fetchAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User findOne(@PathVariable Integer userId) {
		return userService.findOne(userId);
	}

	@PostMapping("/users/saveUser")
	public ResponseEntity<Object> saveUser(@RequestBody @Valid  User user) {
		user = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/deleteUser/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteById(id);
		
	}

}
