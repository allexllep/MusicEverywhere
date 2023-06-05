package com.lepeshkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
