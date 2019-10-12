import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { pizza } from '../model/pizza';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  constructor(private http : HttpClient, private globalService : GlobalService) { }

  deletePizzaById(pizzaId : number) {
    return this.http.delete(`${this.globalService.hostName}/pizzas/` + pizzaId);
  }

  getAllSpecialtyPizzas() {
    return this.http.get(`${this.globalService.hostName}/pizzas`);
  }

  updatePizza(pizzaId : number, newPizza : pizza){
    return this.http.put(`${this.globalService.hostName}/pizzas/${pizzaId}`, newPizza);
  }

  getPSizes(){
    return this.http.get(`${this.globalService.hostName}/psizes`);
  }

  getInventoryItems(){
    return this.http.get(`${this.globalService.hostName}/inventoryitems`);

  }

  createPizza(newPizza : pizza) {
    return this.http.post(`${this.globalService.hostName}/pizzas`, pizza);
  }
}
