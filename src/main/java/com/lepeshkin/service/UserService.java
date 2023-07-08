package com.lepeshkin.service;

import com.lepeshkin.entity.User;

public interface UserService {
	
	User save(User user);
	
	User findById(Long id);
	
	User update(Long id, User user);
	
	void delete(Long id);
}
