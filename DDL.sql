CREATE DATABASE IF NOT EXISTS mscew_db;
USE mscew_db;

CREATE TABLE IF NOT EXISTS users (
	user_id 		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,	
    login			VARCHAR(255) NOT NULL UNIQUE,			
    email 			VARCHAR(255) NOT NULL UNIQUE,
    user_password	VARCHAR(255) NOT NULL,
    PRIMARY KEY 	(user_id)
);  

CREATE TABLE IF NOT EXISTS collections (
	collection_id 		INT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id				BIGINT UNSIGNED NOT NULL,
    collection_title 	VARCHAR(255) NOT NULL,										
    
    PRIMARY KEY 		(collection_id),
    INDEX				(user_id),
    
    FOREIGN KEY			(user_id)
		REFERENCES users(user_id)
        ON UPDATE CASCADE ON DELETE CASCADE
); 

CREATE TABLE IF NOT EXISTS artists (
	artist_id 		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,	
    artist_title 	VARCHAR(255) NOT NULL,										
    PRIMARY KEY 	(artist_id)
);

CREATE TABLE IF NOT EXISTS albums (
	album_id 		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,	
    artist_id 		BIGINT UNSIGNED NOT NULL,
    album_title 	VARCHAR(255) NOT NULL,
    album_year		SMALLINT UNSIGNED,
    
    PRIMARY KEY 	(album_id),
    INDEX			(artist_id),
    
    FOREIGN KEY		(artist_id)
		REFERENCES artists(artist_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);    

CREATE TABLE IF NOT EXISTS songs (
	song_id 		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,	
    album_id 		BIGINT UNSIGNED NOT NULL,
    artist_id		BIGINT UNSIGNED NOT NULL,
    song_title 		VARCHAR(255) NOT NULL,
    song_length 	BIGINT NOT NULL,				
    song_number		TINYINT UNSIGNED,				
    
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