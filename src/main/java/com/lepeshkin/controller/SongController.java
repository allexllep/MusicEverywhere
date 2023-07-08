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

import com.lepeshkin.entity.Song;
import com.lepeshkin.service.SongService;

@RestController
@RequestMapping("artists/albums/")
public class SongController {

	private SongService songService;

	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}
	
	@PostMapping("{albumId}/songs")
	public ResponseEntity<Song> save(@PathVariable("albumId") Long albumId, @RequestBody Song song){
		return new ResponseEntity<Song>(songService.save(albumId, song), HttpStatus.CREATED);
	}
	
	@GetMapping("songs/{songId}")
	public ResponseEntity<Song> findById(@PathVariable("songId") Long songId){
		return new ResponseEntity<Song>(songService.findById(songId), HttpStatus.OK);	
	}
	
	@PutMapping("songs/{songId}")
	public ResponseEntity<Song> update(@PathVariable("songId") Long songId, @RequestBody Song song){
		return new ResponseEntity<Song>(songService.update(songId, song), HttpStatus.OK);
	}
	
	@DeleteMapping("songs/{songId}")
	public ResponseEntity<Song> delete(@PathVariable("songId") Long songId){
		songService.delete(songId);
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
}
