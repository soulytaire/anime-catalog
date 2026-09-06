DELETE FROM anime;
DELETE FROM studios;

INSERT INTO studios (id, name, founded_year, description) VALUES
(1, 'MAPPA', 2011, 'Known for high quality animation in action and drama anime'),
(2, 'Studio Ghibli', 1985, 'Famous for anime feature films'),
(3, 'Kyoto Animation', 1981, 'Famous for slice of life and incredible art');

INSERT INTO anime (title, episodes, score, is_ongoing, format_anime, studio_id, image_url) VALUES
('Chainsaw Man', 12, 8.5, false, 'TV', 1, 'https://i.pinimg.com/...jpg'),
('Howls Moving Castle', 1, 8.2, false, 'Movie', 2, 'https://i.pinimg.com/...jpg');