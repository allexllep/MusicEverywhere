package com.lepeshkin.service;


import java.util.List;

import com.lepeshkin.model.User;

public interface UserService {
	
	User save(User user);
	
	List<User> findAll();
	
	User findById(long id);
	
	User update(User user, Long id);
	
	void delete(long id);
}
