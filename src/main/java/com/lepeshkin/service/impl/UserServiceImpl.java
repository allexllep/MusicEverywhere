package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.entity.User;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.repository.UserRepository;
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
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public User update(Long id, User user) {
		return userRepository.save(
				userRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("User", "Id", id))
				.setEmail(user.getEmail())
				.setLogin(user.getLogin())
				.setUserPassword(user.getUserPassword())
			   );
	}

	@Override
	public void delete(Long id) {
		userRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);	
	}
}
