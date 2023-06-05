package com.lepeshkin.service;

import com.lepeshkin.model.User;

public interface UserService {
	
	User save(User user);
	
	User findById(long id);
	
	User update(User user, Long id);
	
	void delete(long id);
}
