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

import com.lepeshkin.model.Collection;
import com.lepeshkin.service.CollectionService;

@RestController
@RequestMapping("{userId}/collection")
public class CollectionController {
	
	private CollectionService collectionService;

	public CollectionController(CollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@PostMapping
	public ResponseEntity<Collection> save(@PathVariable("userId") Long userId, @RequestBody Collection collection){
		return new ResponseEntity<Collection>(collectionService.save(userId, collection), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Collection>> findAllByUserId(@PathVariable("userId") Long userId){
		return new ResponseEntity<List<Collection>>(collectionService.findAllByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Collection> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Collection>(collectionService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Collection> update(@PathVariable("id") Long id, @RequestBody Collection collection){
		return new ResponseEntity<Collection>(collectionService.update(id, collection), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Collection> delete(@PathVariable("id") Long id){
		collectionService.delete(id);
		return new ResponseEntity<Collection>(HttpStatus.OK);
	}
	
}
