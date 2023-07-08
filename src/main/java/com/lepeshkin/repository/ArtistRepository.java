package com.lepeshkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{}
