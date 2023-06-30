package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.AlbumRepository;
import com.lepeshkin.dao.ArtistRepository;
import com.lepeshkin.dao.CollectionRepository;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.model.Album;
import com.lepeshkin.model.Artist;
import com.lepeshkin.model.Collection;
import com.lepeshkin.service.AlbumService;

@Service
public class AlbumServiceImp implements AlbumService{

	private AlbumRepository albumRepository;
	private ArtistRepository artistRepository;
	private CollectionRepository collectionReposotory;

	public AlbumServiceImp(AlbumRepository albumRepository, ArtistRepository artistRepository,
			CollectionRepository collectionReposotory) {
		super();
		this.albumRepository = albumRepository;
		this.artistRepository = artistRepository;
		this.collectionReposotory = collectionReposotory;
	}

	@Override
	public Album save(Long artistId, Album album) {
		
		Artist artist = artistRepository.findById(artistId).orElseThrow(() -> 
							new ResourceNotFoundException("Artist", "Id", artistId));
		
		album.setArtist(artist).getAlbumsCollections();
		
		Album newAlbum = albumRepository.save(album);
		
		artist.getArtistAlbums().add(newAlbum);
		
		return newAlbum;
	}

	@Override
	public Album findById(Long id) {
		return albumRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Album", "Id", id));
	}

	@Override
	public Album update(Long id, Album album) {
		return albumRepository.save(
					albumRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Album", "Id", id))
					.setAlbumTitle(album.getAlbumTitle())
					.setAlbumYear(album.getAlbumYear()));
	}

	@Override
	public void delete(Long id) {
		albumRepository.deleteById(id);
		
	}

	@Override
	public Album addToCollectionById(Long albumId, Collection clientCollection) {
		
		Album album = albumRepository.findById(albumId).orElseThrow(() -> 
							new ResourceNotFoundException("Album", "Id", albumId));
		
		Collection collection = collectionReposotory.findById(clientCollection.getCollectionId()).orElseThrow(() -> 
									new ResourceNotFoundException("Collection", "Id", clientCollection.getCollectionId()));

		album.getAlbumsCollections().add(collection);
		collection.getCollectionsAlbums().add(album);
		
		albumRepository.save(album);
		collectionReposotory.save(collection);
		
		return album;
	}

}
