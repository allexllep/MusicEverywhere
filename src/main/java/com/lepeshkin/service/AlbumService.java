package com.lepeshkin.service;

import com.lepeshkin.model.Album;
import com.lepeshkin.model.Collection;

public interface AlbumService {

	
	Album save(Long artistId, Album album);
	
	Album findById(Long id);

	Album update(Long id, Album album);

	void delete(Long id);
	
	Album addToCollectionById(Long albumId, Collection collection);
	
}
