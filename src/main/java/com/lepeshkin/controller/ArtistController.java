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

import com.lepeshkin.entity.Artist;
import com.lepeshkin.service.ArtistService;

@RestController
@RequestMapping("artists")
public class ArtistController {

	private ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		super();
		this.artistService = artistService;
	}
	
	@PostMapping
	public ResponseEntity<Artist> save(@RequestBody Artist artist) {
		return new ResponseEntity<Artist>(artistService.save(artist), HttpStatus.CREATED);
	}
	
	@GetMapping("{artistId}")
	public ResponseEntity<Artist> finById(@PathVariable("artistId") Long id){
		return new ResponseEntity<Artist>(artistService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("{artistId}")
	public ResponseEntity<Artist> update(@PathVariable("artistId") Long id, @RequestBody Artist artist){
		return new ResponseEntity<Artist>(artistService.update(id, artist), HttpStatus.OK);	
	}	
	
	@DeleteMapping("{artistId}")
	public ResponseEntity<Artist> delete(@PathVariable("artistId") Long id){
		artistService.delete(id);
		return new ResponseEntity<Artist>(HttpStatus.OK);
	}
}
