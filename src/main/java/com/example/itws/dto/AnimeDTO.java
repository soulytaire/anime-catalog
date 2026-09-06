package com.example.itws.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

public class AnimeDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    private String title;

    @NotNull(message = "Episodes count is required")
    @Min(value = 1, message = "Episodes must be at least 1")
    private Integer episodes;

    @DecimalMin(value = "0.0", message = "Score must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Score cannot exceed 10.0")
    private Double score;

    private Boolean isOngoing = false;

    @NotNull(message = "Studio ID is required")
    private Long studioId;

    private String studioName;
    
    private String imageUrl;


    private String format;

    public AnimeDTO() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getEpisodes() { return episodes; }
    public void setEpisodes(Integer episodes) { this.episodes = episodes; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Boolean getIsOngoing() { return isOngoing; }
    public void setIsOngoing(Boolean isOngoing) { this.isOngoing = isOngoing; }

    public Long getStudioId() { return studioId; }
    public void setStudioId(Long studioId) { this.studioId = studioId; }

    public String getStudioName() { return studioName; }
    public void setStudioName(String studioName) { this.studioName = studioName; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
}