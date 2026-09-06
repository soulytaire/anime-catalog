import { Studio } from './studio.model';

export interface Anime {
  id?: number;
  title: string;
  studioId?: number;
  studioName?: string;
  imageUrl?: string;
  genres?: string[];          
  format: 'TV-series' | 'Movie';
  episodes?: number;        
  score?: number;
  isOngoing: boolean;        // false = finished             
}
