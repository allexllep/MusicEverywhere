package com.lepeshkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
