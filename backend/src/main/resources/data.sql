DELETE FROM anime;
DELETE FROM studios;

INSERT INTO studios (id, name, founded_year, description) VALUES
(1, 'MAPPA', 2011, 'Known for high quality animation in action and drama anime'),
(2, 'Kyoto Animation', 1981, 'Famous for slice of life, incredible art, and emotional depth'),
(3, 'Bones', 1998, 'Renowned for fluid action sequences and sci-fi series'),
(4, 'Madhouse', 1972, 'Legendary studio behind iconic anime series'),
(5, 'Studio Ghibli', 1985, 'Famous worldwide for legendary animated feature films');

INSERT INTO anime (id, title, episodes, score, is_ongoing, studio_id, image_url, format) VALUES
(1, 'Jujutsu Kaisen', 47, 8.6, TRUE, 1, 'posters/1.jpg', 'TV'),
(2, 'Chainsaw Man', 12, 8.5, FALSE, 1, 'posters/2.jpg', 'TV'),
(3, 'Violet Evergarden', 13, 8.9, FALSE, 2, 'posters/3.jpg', 'TV'),
(4, 'Fullmetal Alchemist: Brotherhood', 64, 9.1, FALSE, 3, 'posters/4.jpg', 'TV'),
(5, 'Frieren: Beyond Journey''s End', 38, 8.7, TRUE, 4, 'posters/5.jpg', 'TV'),
(6, 'Kiki''s Delivery Service', 1, 7.8, FALSE, 5, 'posters/6.jpg', 'Movie');
