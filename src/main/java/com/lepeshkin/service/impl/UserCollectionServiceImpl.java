package com.lepeshkin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lepeshkin.entity.UserCollection;
import com.lepeshkin.entity.Album;
import com.lepeshkin.entity.User;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.repository.AlbumRepository;
import com.lepeshkin.repository.UserCollectionRepository;
import com.lepeshkin.repository.UserRepository;
import com.lepeshkin.service.UserCollectionService;

@Service
public class UserCollectionServiceImpl implements UserCollectionService{

	private UserCollectionRepository userCollectionRepository;
	private UserRepository userRepository;
	private AlbumRepository albumRepository;
	
	public UserCollectionServiceImpl(UserCollectionRepository userCollectionRepository, UserRepository userRepository, AlbumRepository albumRepository) {
		super();
		this.userCollectionRepository = userCollectionRepository;
		this.userRepository = userRepository;
		this.albumRepository = albumRepository;
	}

	@Override
	public UserCollection save(Long userId, UserCollection userCollection) {	
		
		User user = userRepository.findById(userId).orElseThrow(() ->
						new ResourceNotFoundException("User", "UserId", userId));
		
		UserCollection newUserCollection = userCollectionRepository.save(userCollection.setUser(user));
		
		user.getUserCollections().add(newUserCollection);	
		
		return newUserCollection;
	}
	
	@Override
	public List<UserCollection> findAllByUserId(Long userId){
		return userRepository.findById(userId).orElseThrow(() -> 
					new ResourceNotFoundException("User", "Id", userId))
				.getUserCollections();
	}
	
	@Override
	public UserCollection findById(Long userCollectionId) {
		return userCollectionRepository.findById(userCollectionId).orElseThrow(() -> 
				new ResourceNotFoundException("Collection", "Id", userCollectionId));
	}

	@Override
	public UserCollection update(Long userCollectionId, UserCollection userCollection) {
		return userCollectionRepository.save(
				userCollectionRepository.findById(userCollectionId).orElseThrow(() ->
						new ResourceNotFoundException("Collection", "Id", userCollectionId))
				.setCollectionTitle(userCollection.getCollectionTitle()));
	}

	@Override
	public void delete(Long userCollectionId) {
		userCollectionRepository.findById(userCollectionId).orElseThrow(() -> 
				new ResourceNotFoundException("Collection", "Id", userCollectionId));
		userCollectionRepository.deleteById(userCollectionId);
	}

	@Override
	public UserCollection addAlbumToCollectionById(Long userCollectionId, Long albumId) {
		
		Album album = albumRepository.findById(albumId).orElseThrow(() -> 
							new ResourceNotFoundException("Album", "Id", albumId));
		
		UserCollection userCollection = userCollectionRepository.findById(userCollectionId).orElseThrow(() -> 
									new ResourceNotFoundException("Collection", "Id", userCollectionId));

		album.getAlbumsCollections().add(userCollection);
		userCollection.getCollectionsAlbums().add(album);
		
		albumRepository.save(album);
		userCollectionRepository.save(userCollection);
		
		return userCollection;
	}

	
}
