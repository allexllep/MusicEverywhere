package com.lepeshkin.controller;

import java.util.List;

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
@RequestMapping("/api/users")
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
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<User>(userService.findById(id),HttpStatus.OK);	
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.update(user, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<User> delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
