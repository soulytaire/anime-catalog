package com.example.itws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "founded_year")
    private Integer foundedYear;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Anime> animeList = new ArrayList<>();

    public Studio() {}

    public Studio(String name, Integer foundedYear, String description) {
        this.name = name;
        this.foundedYear = foundedYear;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getFoundedYear() { return foundedYear; }
    public void setFoundedYear(Integer foundedYear) { this.foundedYear = foundedYear; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Anime> getAnimeList() { return animeList; }
    public void setAnimeList(List<Anime> animeList) { this.animeList = animeList; }
}