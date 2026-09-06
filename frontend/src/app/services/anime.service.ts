import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Anime } from "../models/anime.model";
@Injectable({
  providedIn: "root",
})
export class AnimeService {
  private apiUrl = "http://localhost:8080/api/anime";
  constructor(private http: HttpClient) {}

  getAnimeList(): Observable<Anime[]> {
    return this.http.get<Anime[]>(this.apiUrl);
  }

  getAnimeById(id: number): Observable<Anime> {
    return this.http.get<Anime>(`${this.apiUrl}/${id}`);
  }

  createAnime(anime: Anime): Observable<Anime> {
    return this.http.post<Anime>('http://localhost:8080/api/anime', anime);
  }
 
  deleteAnime(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
