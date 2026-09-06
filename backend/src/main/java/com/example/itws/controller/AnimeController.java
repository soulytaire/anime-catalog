package com.example.itws.controller;

import com.example.itws.dto.AnimeDTO;
import com.example.itws.service.AnimeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anime")
@CrossOrigin(origins = "http://localhost:4200")

public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public ResponseEntity<List<AnimeDTO>> getAllAnime() {
        return ResponseEntity.ok(animeService.getAllAnime());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeDTO> getAnimeById(@PathVariable Long id) {
        return ResponseEntity.ok(animeService.getAnimeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimeDTO>> searchAnime(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long studioId,
            @RequestParam(required = false) Double minScore) {
        return ResponseEntity.ok(animeService.searchAnime(title, studioId, minScore));
    }

    @PostMapping
    public ResponseEntity<AnimeDTO> createAnime(@Valid @RequestBody AnimeDTO animeDTO) {
        AnimeDTO created = animeService.createAnime(animeDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeDTO> updateAnime(@PathVariable Long id, @Valid @RequestBody AnimeDTO animeDTO) {
        AnimeDTO updated = animeService.updateAnime(id, animeDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long id) {
        animeService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }
}