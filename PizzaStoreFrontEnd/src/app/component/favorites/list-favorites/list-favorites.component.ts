import { Component, OnInit } from '@angular/core';
import { GlobalService } from 'src/app/service/global.service';
import { Router } from '@angular/router';
import { PizzaService } from 'src/app/service/pizza.service';
import { pizza } from 'src/app/model/pizza';
import { Subscription } from 'rxjs';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-list-favorites',
  templateUrl: './list-favorites.component.html',
  styleUrls: ['./list-favorites.component.css']
})
export class ListFavoritesComponent implements OnInit {

  constructor(private globalService: GlobalService,
    private router: Router,
    private personService: PersonService) { }

  ngOnInit() {
  }

  subs: Subscription = new Subscription();

  calculatePizzaPrice(pizza: pizza) {
    console.log("Calculating" + pizza.pizzaId);

    let basePrice = 0;

    for (let i = 0; i < pizza.inventoryItems.length; i++) {
      basePrice += pizza.inventoryItems[i].inventoryItem.price * pizza.inventoryItems[i].amount.multiplier;
    }

    basePrice *= pizza.psize.multiplier;

    return basePrice;
  }

  calculatePizzaCalories(pizza: pizza) {

    let baseCalories = 0;

    for (let i = 0; i < pizza.inventoryItems.length; i++) {
      baseCalories += pizza.inventoryItems[i].inventoryItem.topping.calories * pizza.inventoryItems[i].amount.multiplier;
    }

    baseCalories *= pizza.psize.multiplier;

    return baseCalories;
  }

  addPizza() {
    this.router.navigate([`favorites/addpizza`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  showIngredients(pizza: any) {
    pizza.showIngredients = true;
  }

  hideIngredients(pizza: any) {
    pizza.showIngredients = undefined;
  }

  removePizza(pizza: pizza, pizzaIndex: number) {
    this.globalService.currentPerson.favorites.splice(pizzaIndex, 1);
    this.subs.add(this.personService.updatePerson(this.globalService.currentPerson).subscribe(
      (response) => {
        console.log(response);
        this.globalService.currentPerson = response;
      }
    ))
  }

  editPizza(pizzaId: number) {
    this.router.navigate([`favorites/editpizza/${pizzaId}`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  ngOnDestory() {
    this.subs.unsubscribe();
  }

}
