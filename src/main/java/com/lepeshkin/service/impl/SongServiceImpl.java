package com.lepeshkin.service.impl;

import org.springframework.stereotype.Service;

import com.lepeshkin.dao.SongRepository;
import com.lepeshkin.model.Song;
import com.lepeshkin.service.SongService;



@Service
public class SongServiceImpl implements SongService{

	private SongRepository songRepository;
	
	
	public SongServiceImpl(SongRepository songRepository) {
		super();
		this.songRepository = songRepository;
	}


	@Override
	public Song saveSong(Song song) {
		// TODO Auto-generated method stub
		return null;
	}

}
