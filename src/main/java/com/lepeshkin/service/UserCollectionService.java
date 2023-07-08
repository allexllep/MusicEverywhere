package com.lepeshkin.service;

import java.util.List;

import com.lepeshkin.entity.UserCollection;

public interface UserCollectionService {

	UserCollection save(Long userId, UserCollection collection);

	List<UserCollection> findAllByUserId(Long userId);
	
	UserCollection findById(Long id);
	
	UserCollection update(Long id, UserCollection collection);
	
	void delete(Long id);
	
	UserCollection addAlbumToCollectionById(Long collectionId, Long albumId);

}
