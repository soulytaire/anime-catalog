package com.example.itws.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudioDTO {

    private Long id;

    @NotBlank(message = "Studio name is required")
    @Size(max = 100, message = "Studio name cannot exceed 100 characters")
    private String name;

    public StudioDTO() {}

    public StudioDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}