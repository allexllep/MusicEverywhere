package com.lepeshkin.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.UserRepository;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.model.User;
import com.lepeshkin.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(User user) {
		return userRepository.save(user);
	}


	@Override
	public User findById(long id) {
		
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) return user.get();
//		else throw new ResourceNotFoundException("User", "Id", id);
		return userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
	}


	@Override
	public User update(User user, Long id) {
		return userRepository.save(
				userRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("User", "Id", id))
				.setEmail(user.getEmail())
				.setLogin(user.getLogin())
				.setUserPassword(user.getUserPassword())
			   );
	}


	@Override
	public void delete(long id) {
		userRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);	
	}

}
