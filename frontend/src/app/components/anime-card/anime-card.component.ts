import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Anime } from '../../models/anime.model';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-anime-card',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './anime-card.component.html',
  styleUrl: './anime-card.component.scss'
})


export class AnimeCardComponent {
  @Input() anime!: Anime;
  defaultImage = 'posters/1.jpg';
  

  get posterUrl(): string {
      
      if (this.anime?.imageUrl && this.anime.imageUrl.trim() !== '') {
        return this.anime.imageUrl;
      }

  
      if (this.anime?.id) {
        return `posters/${this.anime.id}.jpg`;
      }

  
      return this.defaultImage;
  }

  onImageError(event: Event): void {
  const imgElement = event.target as HTMLImageElement;
  imgElement.src = 'posters/no-poster.jpg';
  }

}


