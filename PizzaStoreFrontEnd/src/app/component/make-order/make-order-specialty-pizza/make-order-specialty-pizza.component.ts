import { Component, OnInit } from '@angular/core';
import { pizza } from 'src/app/model/pizza';
import { PizzaService } from 'src/app/service/pizza.service';
import { pizzaInventoryItem } from 'src/app/model/pizzaInventoryItem';
import { GlobalService } from 'src/app/service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-make-order-specialty-pizza',
  templateUrl: './make-order-specialty-pizza.component.html',
  styleUrls: ['./make-order-specialty-pizza.component.css']
})
export class MakeOrderSpecialtyPizzaComponent implements OnInit {

  constructor(private pizzaService: PizzaService, private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    this.getSpecialtyPizzas();
  }

  pizzas: pizza[];

  getSpecialtyPizzas() {
    this.pizzaService.getSpecialtyPizzas().subscribe(
      (response) => {
        this.pizzas = response;
        console.log(response);
      }
    )
  }

  addToOrder(newPizza: pizza) {
    console.log(newPizza);
    const pizzaToAdd = new pizza(null, newPizza.psize, false, newPizza.inventoryItems);
    pizzaToAdd.inventoryItems.forEach(pII => pII.piiId = null);
    this.globalService.currentOrder.pizzasInOrder.push(pizzaToAdd);
    console.log(this.globalService.currentOrder);
    this.router.navigate([`makeOrder/currentOrder`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  calculatePizzaPrice(pizza: pizza) {
    console.log("Calculating" + pizza.pizzaId);

    let basePrice = 0;

    for (let i = 0; i < pizza.inventoryItems.length; i++) {
      basePrice += pizza.inventoryItems[i].inventoryItem.price * pizza.inventoryItems[i].amount.multiplier;
    }

    basePrice *= pizza.psize.multiplier;

    return basePrice;
  }

  calculateCalories(pizza: pizza) {
    console.log("Calculating" + pizza.pizzaId);

    let baseCalories = 0;

    for (let i = 0; i < pizza.inventoryItems.length; i++) {
      baseCalories += pizza.inventoryItems[i].inventoryItem.topping.calories * pizza.inventoryItems[i].amount.multiplier;
    }

    baseCalories *= pizza.psize.multiplier;

    return baseCalories;
  }
}
