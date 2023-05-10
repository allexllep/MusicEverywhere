package com.lepeshkin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@Column(name = "album_id", nullable = false)
	private int album_id;
	
	@Column(name = "artist_id", nullable = false)
	private int artist_id;
	
	private String song_title;
	private long song_length; // length of the song in seconds
	private int song_number; // number of the song within the album
}
