DELETE FROM anime;
DELETE FROM studio;

INSERT INTO studio (id, name, founded_year) VALUES
(1, 'MAPPA', 2011),
(2, 'Studio Ghibli', 1985),
(3, 'Kyoto Animation', 1981);


INSERT INTO anime (title, episodes, score, is_ongoing, format, studio_id, image_url) VALUES
('Chainsaw Man', 12, 8.5, false, 'TV-series', 1, 'https://i.pinimg.com/...jpg'),
('Howls Moving Castle', 1, 8.2, false, 'Movie', 2, 'https://i.pinimg.com/...jpg');