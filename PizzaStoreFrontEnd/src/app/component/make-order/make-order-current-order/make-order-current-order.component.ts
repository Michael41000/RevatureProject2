import { Component, OnInit } from '@angular/core';
import { GlobalService } from 'src/app/service/global.service';
import { pizza } from 'src/app/model/pizza';
import { Router } from '@angular/router';
import { PorderService } from 'src/app/service/porder.service';

@Component({
  selector: 'app-make-order-current-order',
  templateUrl: './make-order-current-order.component.html',
  styleUrls: ['./make-order-current-order.component.css']
})
export class MakeOrderCurrentOrderComponent implements OnInit {

  constructor(private globalService: GlobalService,
     private router: Router,
     private porderService: PorderService) { }

  ngOnInit() {
    console.log(this.globalService.currentOrder);
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

  calculatePizzaCalories(pizza: pizza) {

    let baseCalories = 0;

    for (let i = 0; i < pizza.inventoryItems.length; i++) {
      baseCalories += pizza.inventoryItems[i].inventoryItem.topping.calories * pizza.inventoryItems[i].amount.multiplier;
    }

    baseCalories *= pizza.psize.multiplier;

    return baseCalories;
  }

  addPizza() {
    this.router.navigate([`makeOrder/store/${this.globalService.currentOrder.store.storeId}`]).then((e) => {
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

  confirmOrder() {
    this.globalService.currentOrder.timeOrdered = new Date();
    this.globalService.currentOrder.person = this.globalService.currentPerson;
    this.globalService.currentOrder.minutesToMake = this.globalService.currentOrder.pizzasInOrder.length * 15;

    console.log(this.globalService.currentOrder);

    this.porderService.createPOrder(this.globalService.currentOrder).subscribe(
      (response) => {
        console.log(response)
        this.globalService.currentOrder = undefined;
        this.router.navigate([`makeOrder`]).then((e) => {
          if (e) {
            console.log("Navigation is successful!");
          } else {
            console.log("Navigation has failed!");
          }
        });
      }
    )
  }

  cancelOrder() {
    this.globalService.currentOrder = undefined;
    this.router.navigate([`makeOrder/stores`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  removePizza(pizzaIndex: number) {
    this.globalService.currentOrder.pizzasInOrder.splice(pizzaIndex, 1);
  }

  editPizza(pizzaIndex: number) {
    this.router.navigate([`makeOrder/customPizza/${pizzaIndex}`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

}
