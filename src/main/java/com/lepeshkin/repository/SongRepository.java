package com.lepeshkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long>{}
