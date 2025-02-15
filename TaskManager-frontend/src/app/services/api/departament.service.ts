import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from '../../app.config';
import { Task } from '../../models/task';


@Injectable({
    providedIn: 'root'
})
export class DepartamentService {
    constructor(private http: HttpClient, @Inject(API_URL) private apiUrl: string) {}

    getTasks(): Observable<Task[]> {
      return this.http.get<Task[]>(`${this.apiUrl}/task`);
    }
}