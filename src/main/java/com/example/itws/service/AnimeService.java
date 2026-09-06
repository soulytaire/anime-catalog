package com.example.itws.service;

import com.example.itws.dto.AnimeDTO;
import com.example.itws.entity.Anime;
import com.example.itws.entity.Studio;
import com.example.itws.repository.AnimeRepository;
import com.example.itws.repository.StudioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final StudioRepository studioRepository;

    public AnimeService(AnimeRepository animeRepository, StudioRepository studioRepository) {
        this.animeRepository = animeRepository;
        this.studioRepository = studioRepository;
    }

    public List<AnimeDTO> getAllAnime() {
        return animeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AnimeDTO> searchAnime(String title, Long studioId, Double minScore) {
        return animeRepository.searchAnime(title, studioId, minScore).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AnimeDTO getAnimeById(Long id) {
        Anime anime = animeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anime not found with id: " + id));
        return mapToDTO(anime);
    }

    @Transactional
    public AnimeDTO createAnime(AnimeDTO dto) {

        Anime anime = new Anime();

        anime.setTitle(dto.getTitle());
        anime.setEpisodes(dto.getEpisodes());
        anime.setScore(dto.getScore());
        anime.setIsOngoing(dto.getIsOngoing() != null ? dto.getIsOngoing() : false);
        anime.setFormat(dto.getFormat());
        anime.setImageUrl(dto.getImageUrl());

        Studio studio = studioRepository.findById(dto.getStudioId())
                .orElseThrow(() -> new RuntimeException("Studio not found with id: " + dto.getStudioId()));
        anime.setStudio(studio);

        Anime savedAnime = animeRepository.save(anime);

        return mapToDTO(animeRepository.save(anime));
    }

    @Transactional
    public AnimeDTO updateAnime(Long id, AnimeDTO dto) {
        Anime anime = animeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anime not found with id: " + id));

        Studio studio = studioRepository.findById(dto.getStudioId())
                .orElseThrow(() -> new RuntimeException("Studio not found with id: " + dto.getStudioId()));

        anime.setTitle(dto.getTitle());
        anime.setEpisodes(dto.getEpisodes());
        anime.setScore(dto.getScore());
        if (dto.getIsOngoing() != null) {
            anime.setIsOngoing(dto.getIsOngoing());
        }
        anime.setStudio(studio);

        return mapToDTO(animeRepository.save(anime));
    }

    @Transactional
    public void deleteAnime(Long id) {
        if (!animeRepository.existsById(id)) {
            throw new RuntimeException("Anime not found with id: " + id);
        }
        animeRepository.deleteById(id);
    }

    private AnimeDTO mapToDTO(Anime anime) {
        AnimeDTO dto = new AnimeDTO();
        dto.setId(anime.getId());
        dto.setTitle(anime.getTitle());
        dto.setEpisodes(anime.getEpisodes());
        dto.setScore(anime.getScore());
        dto.setIsOngoing(anime.getIsOngoing());

        dto.setFormat(anime.getFormat());
        dto.setImageUrl(anime.getImageUrl());

        if (anime.getStudio() != null) {
            dto.setStudioId(anime.getStudio().getId());
            dto.setStudioName(anime.getStudio().getName());
        }

        return dto;
    }
}