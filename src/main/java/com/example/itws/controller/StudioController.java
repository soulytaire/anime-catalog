package com.example.itws.controller;

import com.example.itws.entity.Studio;
import com.example.itws.repository.StudioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
public class StudioController {

    private final StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Studio>> getAllStudios() {
        return ResponseEntity.ok(studioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Studio> createStudio(@Valid @RequestBody Studio studio) {
        Studio saved = studioRepository.save(studio);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studio> getStudioById(@PathVariable Long id) {
        return studioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studio> updateStudio(@PathVariable Long id, @Valid @RequestBody Studio studioDetails) {
        return studioRepository.findById(id)
                .map(existing -> {
                    existing.setName(studioDetails.getName());
                    existing.setFoundedYear(studioDetails.getFoundedYear());
                    existing.setDescription(studioDetails.getDescription());
                    return ResponseEntity.ok(studioRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudio(@PathVariable Long id) {
        if (!studioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        studioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}