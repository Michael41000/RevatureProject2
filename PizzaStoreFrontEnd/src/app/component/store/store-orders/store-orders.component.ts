import { Component, OnInit } from '@angular/core';
import { porder } from 'src/app/model/porder';
import { PorderService } from 'src/app/service/porder.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

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

  

  ngOnDestory() {
    this.subs.unsubscribe();
  }

  

}
