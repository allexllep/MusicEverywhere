package com.lepeshkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.entity.UserCollection;

public interface UserCollectionRepository extends JpaRepository<UserCollection, Long>{}