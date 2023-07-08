package com.lepeshkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{}
