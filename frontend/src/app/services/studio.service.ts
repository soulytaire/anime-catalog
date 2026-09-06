import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Studio {
  id?: number;
  name: string;
  foundedYear?: number;
}

@Injectable({
  providedIn: 'root'
})
export class StudioService {
  private apiUrl = 'http://localhost:8080/api/studios';

  constructor(private http: HttpClient) {}

  getStudios(): Observable<Studio[]> {
    return this.http.get<Studio[]>(this.apiUrl);
  }

  createStudio(studio: Studio): Observable<Studio> {
    return this.http.post<Studio>(this.apiUrl, studio);
  }
}