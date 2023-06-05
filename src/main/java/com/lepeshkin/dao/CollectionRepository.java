package com.lepeshkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lepeshkin.model.Collection;


public interface CollectionRepository extends JpaRepository<Collection, Long>{}
