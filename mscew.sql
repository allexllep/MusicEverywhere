CREATE DATABASE IF NOT EXISTS mscew_database;
USE mscew_database;

CREATE TABLE IF NOT EXISTS mscew_songs (
	song_id 	INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    title 		VARCHAR(255) NOT NULL,			
    artist 		INT,							# foreign key to artist table
    album 		INT,							# foreign key to album table
    length 		LONG,							# length of song in seconds
    PRIMARY KEY (song_id)
);    
    
CREATE TABLE IF NOT EXISTS mscew_albums (
	album_id 	INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    title 		VARCHAR(255) NOT NULL,			
    artist 		INT,							
    image		BLOB,
    PRIMARY KEY (album_id)
);        

CREATE TABLE IF NOT EXISTS mscew_artists (
	artist_id 	INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    title 		VARCHAR(255) NOT NULL,										
    image		BLOB,
    PRIMARY KEY (artist_id)
);

CREATE TABLE IF NOT EXISTS mscew_users (
	user_id 	INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    login		VARCHAR(255) NOT NULL,			
    email 		VARCHAR(255) NOT NULL,						
    image		BLOB,
    PRIMARY KEY (user_id)
);  