package com.lepeshkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{}
