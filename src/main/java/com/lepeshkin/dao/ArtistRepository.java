package com.lepeshkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepeshkin.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
