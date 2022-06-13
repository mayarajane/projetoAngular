import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {

  private baseUrl = 'http://localhost:8080/api-sistema/turma';

  constructor(private http: HttpClient) { }


  getListarTurmas(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  createTurma(turma: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`, turma)
  }

}
