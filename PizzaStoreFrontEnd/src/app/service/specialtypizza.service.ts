import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { pizza } from '../model/pizza';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpecialtypizzaService {

  constructor(private http : HttpClient) { }

  getAllSpecialtyPizza() : Observable<pizza []>{
    return this.http.get<pizza []>(`http://localhost:8080/pizzas`)
  }
}
