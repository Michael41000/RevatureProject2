import { Component, OnInit } from '@angular/core';
import { porder } from 'src/app/model/porder';
import { PorderService } from 'src/app/service/porder.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { pizza } from 'src/app/model/pizza';

@Component({
  selector: 'app-store-orders',
  templateUrl: './store-orders.component.html',
  styleUrls: ['./store-orders.component.css']
})
export class StoreOrdersComponent implements OnInit {

  constructor(private route: ActivatedRoute, private porderService: PorderService) { }

  ngOnInit() {
    this.subs.add(this.route.parent.params.subscribe(params => {
      this.storeId = +params["id"];
      this.showOrders();
    }));
  }

  orders: porder[];
  storeId: number;

  subs: Subscription = new Subscription();

  showOrders() {
    this.subs.add(this.porderService.getPOrdersByStore(this.storeId).subscribe(
      (response) => {
        console.log(response);
        this.orders = response;
      },
      (response) => {

      }
    ));
  }

  show(porder: any) {
    porder.visible = true;
  }

  hide(porder: any) {
    porder.visible = undefined;
  }

  toppingTotalCalories(calories: pizza) {
    let totalCalories: number = 0;

    for (let c of calories.inventoryItems) {
      totalCalories += (c.inventoryItem.topping.calories * c.amount.multiplier);
    }
    return totalCalories * calories.psize.multiplier;
  }

  toppingTotalPrice(pizzaPast: pizza) {
    let total: number = 0;

    for (let i of pizzaPast.inventoryItems) {
      total = total + (i.amount.multiplier * i.inventoryItem.price);
    }

    return total * pizzaPast.psize.multiplier;
  }



  ngOnDestory() {
    this.subs.unsubscribe();
  }



}
