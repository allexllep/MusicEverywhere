package com.lepeshkin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "albumId")
@Table(name = "albums")
public class Album implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long albumId;
	
	@Column(nullable = false)
	private String albumTitle;
	
	@Column(columnDefinition = "SMALLINT UNSIGNED")
	private short albumYear;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artistId", nullable = false)
	private Artist artist;
	
	@JsonManagedReference(value = "ref_album_songs")
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Song> albumSongs = new ArrayList<>();
	 
	@JsonIgnore
	@ManyToMany(mappedBy = "collectionsAlbums", cascade = CascadeType.ALL)
	private List<Collection> albumsCollections = new ArrayList<>();
}
