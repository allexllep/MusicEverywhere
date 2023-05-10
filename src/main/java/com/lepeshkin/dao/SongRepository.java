package com.lepeshkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

}
