package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.AlbumRepository;
import com.lepeshkin.dao.SongRepository;
import com.lepeshkin.exception.ResourceNotFoundException;
import com.lepeshkin.model.Album;
import com.lepeshkin.model.Song;
import com.lepeshkin.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	private SongRepository songRepository;
	private AlbumRepository albumRepository;
	
	
	
	public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
		super();
		this.songRepository = songRepository;
		this.albumRepository = albumRepository;
	}

	@Override
	public Song save(Long albumId, Song song) {
		
		Album album = albumRepository.findById(albumId).orElseThrow(() -> 
						new ResourceNotFoundException("Album", "Id", albumId));
		
		Song newSong = songRepository.save(song.setAlbum(album));
		
		album.getAlbumSongs().add(newSong);
		
		return newSong;
	}

	@Override
	public Song findById(Long id) {
		return songRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Song", "Id", id));
	}

	@Override
	public Song update(Long id, Song song) {
		return songRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Song", "Id", id))
				.setSongTitle(song.getSongTitle())
				.setSongLength(song.getSongLength())
				.setSongNumber(song.getSongNumber());
	}

	@Override
	public void delete(Long id) {
		songRepository.deleteById(id);		
	}

}
