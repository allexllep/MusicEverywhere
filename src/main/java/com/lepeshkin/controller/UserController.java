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

import com.lepeshkin.model.User;
import com.lepeshkin.service.UserService;

@RestController
@RequestMapping
public class UserController {

	private UserService userService;


	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("registration")
	public ResponseEntity<User> save(@RequestBody User user){
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("login/{userId}")
	public ResponseEntity<User> findById(@PathVariable("userId") Long id) {
		return new ResponseEntity<User>(userService.findById(id),HttpStatus.OK);	
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<User> update(@PathVariable("userId") Long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.update(user, id), HttpStatus.OK);
	}

	@DeleteMapping("{userId}")
	public ResponseEntity<User> delete(@PathVariable("userId") Long id) {
		userService.delete(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
