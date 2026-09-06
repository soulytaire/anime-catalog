import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { AnimeService } from "../../services/anime.service";
import { Anime } from "../../models/anime.model";
import { AnimeCardComponent } from "../anime-card/anime-card.component";

@Component({
  selector: "app-anime-list",
  standalone: true,
  imports: [CommonModule, AnimeCardComponent],
  templateUrl: "./anime-list.component.html",
  styleUrl: "./anime-list.component.scss",
})
export class AnimeListComponent implements OnInit {
  animeList: Anime[] = [
    /* { 
      id: 1, 
      title: 'Frieren: Beyond Journey\'s End', 
      episodes: 28, 
      score: 9.1, 
      studioId: 1, 
      genres: ['Fantasy', 'Adventures'],      
      format: 'TV-series',        
      isOngoing: true,
      year: 2023 
    } */
  ];

  
  constructor(private animeService: AnimeService) {}

  ngOnInit(): void {
    this.animeService.getAnimeList().subscribe({
      next: (data) => {
        this.animeList = data;
      },
      error: (err) => {
        console.error("Error status:", err.status);
        console.error("Full error details:", err);
      },
    });
  }
}
