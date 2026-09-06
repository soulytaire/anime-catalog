import { Routes } from '@angular/router';
import { AnimeListComponent } from './components/anime-list/anime-list.component';
import { AnimeDetailComponent } from './components/anime-detail/anime-detail.component';
import { AddAnimeComponent } from './components/add-anime/add-anime.component';

export const routes: Routes = [
  { path: '', component: AnimeListComponent },
  { path: 'add', component: AddAnimeComponent },
  { path: 'anime/:id', component: AnimeDetailComponent },
  { path: '**', redirectTo: '' }
];