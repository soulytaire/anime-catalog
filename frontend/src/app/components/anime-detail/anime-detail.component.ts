import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { AnimeService } from '../../services/anime.service';
import { Anime } from '../../models/anime.model';

@Component({
  selector: 'app-anime-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './anime-detail.component.html',
  styleUrl: './anime-detail.component.scss'
})
export class AnimeDetailComponent implements OnInit {
  anime?: Anime;
  loading = true;
  defaultImage = 'posters/no-poster.jpg';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private animeService: AnimeService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      const id = Number(idParam);
      this.animeService.getAnimeById(id).subscribe({
        next: (data) => {
          this.anime = data;
          this.loading = false;
        },
        error: (err) => {
          console.error('Error with loading info about this anime:', err);
          this.loading = false;
        }
      });
    }
  }

  onDelete(): void {
      if (!this.anime?.id) return;

      if (confirm(`Are you sure you want to delete "${this.anime.title}"?`)) {
        this.animeService.deleteAnime(this.anime.id).subscribe(() => {
          this.router.navigate(['/']); 
        });
      }
    }

  get displayFormat(): string {
    if (!this.anime?.format) return '';
    const fmt = this.anime.format.toUpperCase();
    if (fmt === 'MOVIE') return 'MOVIE';
    if (fmt === 'TV') return 'TV-SERIES';
    return fmt;
  }

  get posterUrl(): string {
    if (this.anime?.imageUrl && this.anime.imageUrl.trim() !== '') {
      return this.anime.imageUrl;
    }
  return this.anime?.id ? `posters/${this.anime.id}.jpg` : this.defaultImage;
  }


  onImageError(event: Event) {
    (event.target as HTMLImageElement).src = this.defaultImage;
  }
}