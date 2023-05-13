package com.lepeshkin.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "collections")
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long collection_id;
	
	@Column(nullable = false)
	private String collection_title;
	
	@Column(columnDefinition = "BIGINT UNSIGNED")
	private long user_id;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "collection_id"),
				inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "album_id"))
	private List<Album> albumList;
}
