package com.lepeshkin.service;

import com.lepeshkin.entity.Artist;

public interface ArtistService {

	Artist save(Artist artist);
	
	Artist findById(Long id);

	Artist update(Long id, Artist artist);

	void delete(Long id);
}
