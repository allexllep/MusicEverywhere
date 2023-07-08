package com.lepeshkin.service;

import com.lepeshkin.entity.Song;

public interface SongService{

	Song save(Long albumId, Song song);
	
	Song findById(Long id);

	Song update(Long id, Song song);

	void delete(Long id);
	
}
