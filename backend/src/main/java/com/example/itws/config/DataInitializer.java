package com.example.itws.config;

import com.example.itws.entity.Anime;
import com.example.itws.entity.Studio;
import com.example.itws.repository.AnimeRepository;
import com.example.itws.repository.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudioRepository studioRepository;
    private final AnimeRepository animeRepository;

    public DataInitializer(StudioRepository studioRepository, AnimeRepository animeRepository) {
        this.studioRepository = studioRepository;
        this.animeRepository = animeRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (studioRepository.count() == 0 && animeRepository.count() == 0) {

            // Studios
            Studio mappa = new Studio();
            mappa.setName("MAPPA");

            Studio madhouse = new Studio();
            madhouse.setName("Madhouse");

            Studio kyotoAnimation = new Studio();
            kyotoAnimation.setName("Kyoto Animation");

            studioRepository.saveAll(List.of(mappa, madhouse, kyotoAnimation));

            // Anime
            Anime fma = new Anime();
            fma.setTitle("Fullmetal Alchemist: Brotherhood");
            fma.setEpisodes(64);
            fma.setScore(9.1);
            fma.setIsOngoing(false);
            fma.setStudio(madhouse);

            Anime jujutsu = new Anime();
            jujutsu.setTitle("Jujutsu Kaisen");
            jujutsu.setEpisodes(47);
            jujutsu.setScore(8.6);
            jujutsu.setIsOngoing(true);
            jujutsu.setStudio(mappa);

            Anime violet = new Anime();
            violet.setTitle("Violet Evergarden");
            violet.setEpisodes(13);
            violet.setScore(8.6);
            violet.setIsOngoing(false);
            violet.setStudio(kyotoAnimation);

            animeRepository.saveAll(List.of(fma, jujutsu, violet));

            System.out.println(">>> Test data is loaded into DB sucessfully");
        }
    }
}