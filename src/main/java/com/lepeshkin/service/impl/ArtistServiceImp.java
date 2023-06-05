package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.ArtistRepository;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.model.Artist;
import com.lepeshkin.service.ArtistService;

@Service
public class ArtistServiceImp implements ArtistService{

	private ArtistRepository artistRepository;
	
	public ArtistServiceImp(ArtistRepository artistRepository) {
		super();
		this.artistRepository = artistRepository;
	}

	@Override
	public Artist save(Artist artist) {
		return artistRepository.save(artist);
	}

	@Override
	public Artist findById(Long id) {
		return artistRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Artist", "Id", id));
	}

	@Override
	public Artist update(Long id, Artist artist) {
		return artistRepository.save(
					artistRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Artist", "Id", id))
					.setArtistName(artist.getArtistName())
					.setCountry(artist.getCountry()));
	}

	@Override
	public void delete(Long id) {
		artistRepository.deleteById(id);
		
	}

}
