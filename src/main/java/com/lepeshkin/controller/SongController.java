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

import com.lepeshkin.model.Song;
import com.lepeshkin.service.SongService;

@RestController
@RequestMapping("{artistId}/{albumId}/song")
public class SongController {

	private SongService songService;

	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}
	
	@PostMapping
	public ResponseEntity<Song> save(@PathVariable("albumId") Long albumId, @RequestBody Song song){
		return new ResponseEntity<Song>(songService.save(albumId, song), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Song> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Song>(songService.findById(id), HttpStatus.OK);	
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Song> update(@PathVariable("id") Long id, @RequestBody Song song){
		return new ResponseEntity<Song>(songService.update(id, song), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Song> delete(@PathVariable("id") Long id){
		songService.delete(id);
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
}
