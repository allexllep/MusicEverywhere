package com.lepeshkin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lepeshkin.entity.User;
import com.lepeshkin.service.UserService;

@RestController
@RequestMapping("{users}")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<User> findById(@PathVariable("userId") Long userId) {
		return new ResponseEntity<User>(userService.findById(userId),HttpStatus.OK);	
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<User> update(@PathVariable("userId") Long userId, @RequestBody User user){
		return new ResponseEntity<User>(userService.update(userId, user), HttpStatus.OK);
	}

	@DeleteMapping("{userId}")
	public ResponseEntity<User> delete(@PathVariable("userId") Long userId) {
		userService.delete(userId);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
