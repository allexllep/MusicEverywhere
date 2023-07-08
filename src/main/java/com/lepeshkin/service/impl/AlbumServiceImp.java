package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.entity.Album;
import com.lepeshkin.entity.Artist;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.repository.AlbumRepository;
import com.lepeshkin.repository.ArtistRepository;
import com.lepeshkin.service.AlbumService;

@Service
public class AlbumServiceImp implements AlbumService{

	private AlbumRepository albumRepository;
	private ArtistRepository artistRepository;

	public AlbumServiceImp(AlbumRepository albumRepository, ArtistRepository artistRepository) {
		super();
		this.albumRepository = albumRepository;
		this.artistRepository = artistRepository;
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
}
