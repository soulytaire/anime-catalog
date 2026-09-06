package com.example.itws.service;

import com.example.itws.dto.StudioDTO;
import com.example.itws.entity.Studio;
import com.example.itws.repository.StudioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<StudioDTO> getAllStudios() {
        return studioRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StudioDTO getStudioById(Long id) {
        Studio studio = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio not found with id: " + id));
        return mapToDTO(studio);
    }

    @Transactional
    public StudioDTO createStudio(StudioDTO dto) {
        Studio studio = new Studio();
        studio.setName(dto.getName());
        return mapToDTO(studioRepository.save(studio));
    }

    @Transactional
    public StudioDTO updateStudio(Long id, StudioDTO dto) {
        Studio studio = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio not found with id: " + id));

        studio.setName(dto.getName());
        return mapToDTO(studioRepository.save(studio));
    }

    @Transactional
    public void deleteStudio(Long id) {
        if (!studioRepository.existsById(id)) {
            throw new RuntimeException("Studio not found with id: " + id);
        }
        studioRepository.deleteById(id);
    }

    private StudioDTO mapToDTO(Studio studio) {
        return new StudioDTO(studio.getId(), studio.getName());
    }
}