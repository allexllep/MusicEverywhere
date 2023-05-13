package com.lepeshkin.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long artist_id;
	
	@Column(nullable = false)
	private String artist_title;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "artist_id")
	private List<Album> albumList = new ArrayList<>();
}
