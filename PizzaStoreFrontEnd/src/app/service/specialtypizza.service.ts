import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { pizza } from '../model/pizza';
import { Observable } from 'rxjs';
import { GlobalService } from './global.service';

@Injectable({
  providedIn: 'root'
})
export class SpecialtypizzaService {

  constructor(private http : HttpClient, private globalService: GlobalService) { }

  getAllSpecialtyPizza() : Observable<pizza []>{
    return this.http.get<pizza []>(`${this.globalService.hostName}/pizzas`)
  }
}
