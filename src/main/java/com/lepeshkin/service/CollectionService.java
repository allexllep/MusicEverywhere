package com.lepeshkin.service;

import java.util.List;

import com.lepeshkin.model.Collection;

public interface CollectionService {

	Collection save(Long userId, Collection collection);

	List<Collection> findAllByUserId(Long userId);
	
	Collection findById(Long id);
	
	Collection update(Long id, Collection collection);
	
	void delete(Long id);

}
