import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AnimeService } from '../../services/anime.service';
import { StudioService, Studio } from '../../services/studio.service';
import { Anime } from '../../models/anime.model';

@Component({
  selector: 'app-add-anime',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './add-anime.component.html',
  styleUrl: './add-anime.component.scss'
})
export class AddAnimeComponent implements OnInit {
  studios: Studio[] = [];
  

  newStudioName = '';

  animeData: Anime = {
    title: '',
    episodes: 12,
    score: 8.0,
    isOngoing: false,
    format: 'TV-series',
    studioId: undefined,
    imageUrl: ''
  };

  constructor(
    private animeService: AnimeService,
    private studioService: StudioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadStudios();
  }

  loadStudios(): void {
    this.studioService.getStudios().subscribe(data => {
      this.studios = data;
      if (this.studios.length > 0) {
        this.animeData.studioId = this.studios[0].id;
      }
    });
  }


  onAddStudio(): void {
    if (!this.newStudioName.trim()) return;

    this.studioService.createStudio({ name: this.newStudioName }).subscribe(createdStudio => {
      this.studios.push(createdStudio);
      this.animeData.studioId = createdStudio.id;
      this.newStudioName = '';
    });
  }


  onSubmitAnime(): void {
    if (!this.animeData.title || !this.animeData.studioId) {
      alert('Fill in Title and Select Studio!');
      return;
    }

    this.animeService.createAnime(this.animeData).subscribe(() => {
      this.router.navigate(['/']); 
    });
  }

imageValid: boolean | null = null; 

  onUrlInput(): void {
    this.imageValid = null; 
  }

  onImageLoadSuccess(): void {
    this.imageValid = true;
  }

  onImageLoadError(): void {
    this.imageValid = false;
  }

  // Load selected local file for poster
  onFileSelected(event: Event): void {
    const fileInput = event.target as HTMLInputElement;
    if (fileInput.files && fileInput.files[0]) {
      const file = fileInput.files[0];
      const reader = new FileReader();

      reader.onload = () => {
        this.animeData.imageUrl = reader.result as string;
        this.imageValid = true;
      };

      reader.readAsDataURL(file);
    }
  }

}