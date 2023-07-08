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

import com.lepeshkin.entity.Album;
import com.lepeshkin.service.AlbumService;

@RestController
@RequestMapping("artists/")
public class AlbumController {

	private AlbumService albumService;
	
	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}

	@PostMapping("{artistId}/albums")
	public ResponseEntity<Album> save(@PathVariable("artistId") Long artistId, @RequestBody Album album){
		return new ResponseEntity<Album>(albumService.save(artistId, album), HttpStatus.OK);
	}
	
	@GetMapping("albums/{albumId}")
	public ResponseEntity<Album> findById(@PathVariable("albumId") Long albumId){
		return new ResponseEntity<Album>(albumService.findById(albumId), HttpStatus.OK);
	}
	
	@PutMapping("albums/{albumId}")
	public ResponseEntity<Album> update(@PathVariable("albumId") Long albumId, @RequestBody Album album){
		return new ResponseEntity<Album>(albumService.update(albumId, album), HttpStatus.OK);
	}
	
	@DeleteMapping("albums/{albumId}")
	public ResponseEntity<Album> delete(@PathVariable("albumId") Long albumId){
		albumService.delete(albumId);
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
}
