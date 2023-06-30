USE mscew_db;

INSERT INTO users(login, email, user_password)
VALUES ('aaa', 'aaa@gmail.com', 'aaa111'),
			('bbb', 'bbb@gmail.com', 'bbb222'),
			('admin', 'ccc@gmail.com', 'ccc333');
			
INSERT INTO collections(collection_title, user_id)
VALUES ('Post rock', 1), ('Metal', 1), ('Other', 1);

INSERT INTO artists(artist_name, country)
VALUES ('If These Trees Could Talk', 'USA'),
			('Finntroll ', 'Finland'),
			('Beethoven, Ludwig van', 'Germany');
			
INSERT INTO albums(album_title, album_year, artist_id)
VALUES ('If These Trees Could Talk', 2006, 1),
	   ('Above the Earth, Below the Sky', 2009, 1),
	   ('Nattfödd', 2004, 2),
	   ('Untiteled', NULL, 3);
			
INSERT INTO songs(song_title, song_length, song_number, album_id)
VALUES ('Malabar Front', 485, 1, 1), ('Smoke Stacks', 384, 2, 1), ('The Friscalating Dusklight', 272, 3, 1),
			('From Roots to Needles', 402, 1, 2), ('What''s in the Ground Belongs to You',  254, 2, 2),
			('Vindfärd/Människopesten', 336, 1, 3),	('Eliytres', 226, 2, 3),	('Fiskarens Fiende', 227, 3, 3),	('Trollhammaren', 213, 4, 3),
			('Piano Sonata No. 14, Moonlight', 902, 1, 4);
			
INSERT INTO albums_collections(album_id, collection_id)
VALUES ( 1, 1), (2, 1), (2, 2), (3, 2), (4, 3);