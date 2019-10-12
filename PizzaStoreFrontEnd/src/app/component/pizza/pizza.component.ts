import { Component, OnInit, Input } from '@angular/core';
import { pizza } from 'src/app/model/pizza';

@Component({
  selector: '[app-pizza]',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {

  //@Input("pizza") pizza: pizza;
  //@Input("index") index: number;
  //@Input("pizzaArrayLength") pizzaArrayLength: number;
  @Input() props: { pizza: pizza, index: number, pizzaArrayLength: number };

  constructor() { }

  ngOnInit() {
    this.pizza = this.props.pizza;
    this.index = this.props.index;
    this.pizzaArrayLength = this.props.pizzaArrayLength;
    console.log(this.pizza);
    console.log(this.index);
    console.log(this.pizzaArrayLength);
  }

  pizza: pizza;
  index: number;
  pizzaArrayLength: number;

  toppingTotalCalories(pizzaC: pizza) {
    let totalCalories: number = 0;

    for (let c of pizzaC.inventoryItems) {
      totalCalories += (c.inventoryItem.topping.calories * c.amount.multiplier);
    }
    return totalCalories * pizzaC.psize.multiplier;
  }


  toppingTotalPrice(pizzaT: pizza) {
    let total: number = 0;

    for (let i of pizzaT.inventoryItems) {
      total = total + (i.amount.multiplier * i.inventoryItem.price);
    }

    return total * pizzaT.psize.multiplier;
  }

  show(pizza: any) {
    pizza.visible = true;
  }


  hide(pizza: any) {
    pizza.visible = undefined;
  }


}
