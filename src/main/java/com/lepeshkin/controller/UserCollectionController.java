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

import com.lepeshkin.entity.UserCollection;
import com.lepeshkin.service.UserCollectionService;

@RestController
@RequestMapping("users/{userId}/collections")
public class UserCollectionController {
	
	private UserCollectionService userCollectionService;

	public UserCollectionController(UserCollectionService userCollectionService) {
		super();
		this.userCollectionService = userCollectionService;
	}
	
	@PostMapping
	public ResponseEntity<UserCollection> save(@PathVariable("userId") Long userId, @RequestBody UserCollection userCollection){
		return new ResponseEntity<UserCollection>(userCollectionService.save(userId, userCollection), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserCollection>> findAllByUserId(@PathVariable("userId") Long userId){
		return new ResponseEntity<List<UserCollection>>(userCollectionService.findAllByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("{collectionId}")
	public ResponseEntity<UserCollection> findById(@PathVariable("collectionId") Long userCollectionId){
		return new ResponseEntity<UserCollection>(userCollectionService.findById(userCollectionId), HttpStatus.OK);
	}
	
	@PutMapping("{collectionId}")
	public ResponseEntity<UserCollection> update(@PathVariable("collectionId") Long userCollectionId, @RequestBody UserCollection userCollection){
		return new ResponseEntity<UserCollection>(userCollectionService.update(userCollectionId, userCollection), HttpStatus.OK);
	}
	
	@DeleteMapping("{collectionId}")
	public ResponseEntity<UserCollection> delete(@PathVariable("collectionId") Long userCollectionId){
		userCollectionService.delete(userCollectionId);
		return new ResponseEntity<UserCollection>(HttpStatus.OK);
	}
	
}
