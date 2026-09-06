package com.example.itws.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private Integer episodes;

    private Double score;

    @Column(name = "is_ongoing")
    private Boolean isOngoing = false;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;


    @Column(name = "image_url", columnDefinition = "LONGTEXT")
    private String imageUrl;

    @Column(name = "format")
    private String format;


    public Anime() {}

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

    public Studio getStudio() { return studio; }
    public void setStudio(Studio studio) { this.studio = studio; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

}