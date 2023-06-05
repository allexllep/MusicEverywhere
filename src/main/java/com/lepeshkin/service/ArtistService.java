package com.lepeshkin.service;

import com.lepeshkin.model.Artist;

public interface ArtistService {

	Artist save(Artist artist);
	
	Artist findById(Long id);

	Artist update(Long id, Artist artist);

	void delete(Long id);
}
