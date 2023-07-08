package com.lepeshkin.service;

import com.lepeshkin.entity.Album;

public interface AlbumService {
	
	Album save(Long artistId, Album album);
	
	Album findById(Long id);

	Album update(Long id, Album album);

	void delete(Long id);
	
}
