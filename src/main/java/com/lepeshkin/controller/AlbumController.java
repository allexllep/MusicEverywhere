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

import com.lepeshkin.model.Album;
import com.lepeshkin.service.AlbumService;

@RestController
@RequestMapping("{artistId}/album")
public class AlbumController {

	private AlbumService albumService;
	
	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}

	@PostMapping
	public ResponseEntity<Album> save(@PathVariable("artistId") Long artistId, @RequestBody Album album){
		return new ResponseEntity<Album>(albumService.save(artistId, album), HttpStatus.OK);
	}
	
	@PostMapping("{albumId}")
	public ResponseEntity<Album> addToCollectionById(@PathVariable("albumId") Long albumId, @RequestBody Long collectionId){
		return new ResponseEntity<Album>(albumService.addToCollectionById(albumId, collectionId), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Album> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Album>(albumService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Album> update(@PathVariable("id") Long id, @RequestBody Album album){
		return new ResponseEntity<Album>(albumService.update(id, album), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Album> delete(@PathVariable("id") Long id){
		albumService.delete(id);
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
}
