import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseUrlIdeas = 'http://localhost:1313/idea';
  private baseUrlRetos = 'http://localhost:1313/reto';

  constructor(private http: HttpClient) { }

  getIdeasList(): Observable<any> {
    return this.http.get(`${this.baseUrlIdeas}`);
  }

  getRetosList(): Observable<any> {
    return this.http.get(`${this.baseUrlRetos}`);
  }

}
