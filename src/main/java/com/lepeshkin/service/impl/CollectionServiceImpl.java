package com.lepeshkin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.CollectionRepository;
import com.lepeshkin.dao.UserRepository;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.model.Collection;
import com.lepeshkin.model.User;
import com.lepeshkin.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService{

	private CollectionRepository collectionRepository;
	private UserRepository userRepository;
	
	public CollectionServiceImpl(CollectionRepository collectionRepository, UserRepository userRepository) {
		super();
		this.collectionRepository = collectionRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Collection save(Long userId, Collection collection) {	
		
		User user = userRepository.findById(userId).orElseThrow(() ->
						new ResourceNotFoundException("User", "UserId", userId));
		
		Collection newCollection = collectionRepository.save(collection.setUser(user));
		
		user.getUserCollections().add(newCollection);	
		
		return newCollection;
	}
	
	@Override
	public List<Collection> findAllByUserId(Long userId){
		return userRepository.findById(userId).orElseThrow(() -> 
					new ResourceNotFoundException("User", "Id", userId))
				.getUserCollections();
	}
	
	@Override
	public Collection findById(Long id) {
		return collectionRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Collection", "Id", id));
	}

	@Override
	public Collection update(Long id, Collection collection) {
		return collectionRepository.save(
				collectionRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("Collection", "Id", id))
				.setCollectionTitle(collection.getCollectionTitle()));
	}

	@Override
	public void delete(Long id) {
		collectionRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Collection", "Id", id));
		collectionRepository.deleteById(id);
	}

}
