import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { Observable } from 'rxjs';
import { pizza } from '../model/pizza';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  constructor(private http : HttpClient, private globalService : GlobalService) { }

  getSpecialtyPizzas(): Observable<pizza[]> {
    return this.http.get<pizza[]>(`${this.globalService.hostName}/pizzas`)
  }

  removeSpecialtyPizza(pizza: pizza) : Observable<pizza[]> {
    return this.http.delete<pizza[]>(`${this.globalService.hostName}/pizzas/${pizza.pizzaId}`)
  }

  addPizza(pizza: pizza) : Observable<pizza> {
    return this.http.post<pizza>(`${this.globalService.hostName}/pizzas`, pizza);
  }

  getPizza(pizzaId: number) : Observable<pizza> {
    return this.http.get<pizza>(`${this.globalService.hostName}/pizzas/${pizzaId}`);
  }

  updatePizza(pizza: pizza) : Observable<pizza> {
    return this.http.put<pizza>(`${this.globalService.hostName}/pizzas/${pizza.pizzaId}`, pizza)
  }
}
