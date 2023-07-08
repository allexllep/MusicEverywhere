package com.lepeshkin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lepeshkin.entity.UserCollection;
import com.lepeshkin.entity.User;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.repository.UserCollectionRepository;
import com.lepeshkin.repository.UserRepository;
import com.lepeshkin.service.UserCollectionService;

@Service
public class UserCollectionServiceImpl implements UserCollectionService{

	private UserCollectionRepository collectionRepository;
	private UserRepository userRepository;
	
	public UserCollectionServiceImpl(UserCollectionRepository collectionRepository, UserRepository userRepository) {
		super();
		this.collectionRepository = collectionRepository;
		this.userRepository = userRepository;
	}

	@Override
	public UserCollection save(Long userId, UserCollection collection) {	
		
		User user = userRepository.findById(userId).orElseThrow(() ->
						new ResourceNotFoundException("User", "UserId", userId));
		
		UserCollection newCollection = collectionRepository.save(collection.setUser(user));
		
		user.getUserCollections().add(newCollection);	
		
		return newCollection;
	}
	
	@Override
	public List<UserCollection> findAllByUserId(Long userId){
		return userRepository.findById(userId).orElseThrow(() -> 
					new ResourceNotFoundException("User", "Id", userId))
				.getUserCollections();
	}
	
	@Override
	public UserCollection findById(Long id) {
		return collectionRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Collection", "Id", id));
	}

	@Override
	public UserCollection update(Long id, UserCollection collection) {
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
