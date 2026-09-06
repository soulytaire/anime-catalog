SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS anime;
DROP TABLE IF EXISTS studios;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE IF NOT EXISTS studios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    founded_year INT,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS anime (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    episodes INT NOT NULL CHECK (episodes > 0),
    score DECIMAL(3,2) CHECK (score >= 0.0 AND score <= 10.0),
    is_ongoing BOOLEAN DEFAULT FALSE,
    studio_id BIGINT NOT NULL,
    image_url VARCHAR(255),
    format_anime VARCHAR(20) DEFAULT 'TV',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_anime_studio FOREIGN KEY (studio_id) REFERENCES studios(id) ON DELETE CASCADE
);


CREATE INDEX idx_anime_studio ON anime(studio_id);
CREATE INDEX idx_anime_score ON anime(score);


INSERT INTO studios (id, name, founded_year, description) VALUES
(1, 'MAPPA', 2011, 'Known for high quality animation in action and drama anime'),
(2, 'Kyoto Animation', 1981, 'Famous for slice of life, incredible art, and emotional depth'),
(3, 'Bones', 1998, 'Renowned for fluid action sequences and sci-fi series'),
(4, 'Madhouse', 1972, '');


INSERT INTO anime (id, title, episodes, score, is_ongoing, studio_id, image_url, format_anime) VALUES
(1, 'Jujutsu Kaisen', 47, 8.6, TRUE, 1, 'posters/1.jpg', 'TV'),
(2, 'Chainsaw Man', 12, 8.5, FALSE, 1, 'posters/2.jpg', 'TV'),
(3, 'Violet Evergarden', 13, 8.9, FALSE, 2, 'posters/3.jpg', 'TV'),
(4, 'Fullmetal Alchemist: Brotherhood', 64, 9.1, FALSE, 3, 'posters/4.jpg', 'TV'),
(5, 'Frieren: Beyond Journey\'s End', 38, 8.7, TRUE, 4, 'posters/5.jpg', 'TV');

COMMIT;