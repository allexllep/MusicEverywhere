CREATE DATABASE IF NOT EXISTS mscew_db;
USE mscew_db;

CREATE TABLE IF NOT EXISTS users (
	user_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    login			VARCHAR(255) NOT NULL UNIQUE,			
    email 			VARCHAR(255) NOT NULL UNIQUE,
    user_password	VARCHAR(255) NOT NULL,
    user_image		BLOB,
    PRIMARY KEY 	(user_id)
);  

CREATE TABLE IF NOT EXISTS collections (
	collection_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id				INT UNSIGNED NOT NULL,
    collection_title 	VARCHAR(255) NOT NULL,										
    collection_image	BLOB,
    
    PRIMARY KEY 		(collection_id),
    INDEX				(user_id),
    
    FOREIGN KEY			(user_id)
		REFERENCES users(user_id)
        ON UPDATE CASCADE ON DELETE CASCADE
); 

CREATE TABLE IF NOT EXISTS artists (
	artist_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    artist_title 	VARCHAR(255) NOT NULL,										
    artist_image	BLOB,
    PRIMARY KEY 	(artist_id)
);

CREATE TABLE IF NOT EXISTS albums (
	album_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    artist_id 		INT UNSIGNED NOT NULL,
    album_title 	VARCHAR(255) NOT NULL,
    album_year		YEAR,
    album_image		BLOB,
    
    PRIMARY KEY 	(album_id),
    INDEX			(artist_id),
    
    FOREIGN KEY		(artist_id)
		REFERENCES artists(artist_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);    

CREATE TABLE IF NOT EXISTS songs (
	song_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,	
    album_id 		INT UNSIGNED NOT NULL,
    artist_id		INT UNSIGNED NOT NULL,
    song_title 		VARCHAR(255) NOT NULL,
    song_length 	LONG,					# length of the song in seconds
    song_number		INT,					# number of the song within the album
    
    PRIMARY KEY 	(song_id),
    INDEX			(album_id),
    INDEX			(artist_id),
    
    FOREIGN KEY		(album_id)
		REFERENCES albums(album_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	
    FOREIGN KEY		(artist_id)
		REFERENCES artists(artist_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);    

CREATE TABLE IF NOT EXISTS album_collection(
	album_id 		INT UNSIGNED NOT NULL,
    collection_id 	INT UNSIGNED NOT NULL,
    PRIMARY KEY 	(album_id, collection_id),
    INDEX			(album_id),
	INDEX			(collection_id),
    
    FOREIGN KEY		(album_id)
		REFERENCES albums(album_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
        
    FOREIGN KEY		(collection_id)
		REFERENCES collections(collection_id)
        ON UPDATE CASCADE ON DELETE CASCADE   
);