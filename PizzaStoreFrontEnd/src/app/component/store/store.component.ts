import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StoreService } from 'src/app/service/store.service';
import { store } from 'src/app/model/store';
import { PorderService } from 'src/app/service/porder.service';
import { InventoryitemService } from 'src/app/service/inventoryitem.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  constructor(private storeService: StoreService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.subs.add(this.route.params.subscribe(params => {
      this.storeId = +params["id"];
    }));

    this.subs.add(this.storeService.getStore(this.storeId).subscribe(
      (response) => {
        console.log(response);
        this.store = response;
      },
      (response) => {

      }
    ));
  }

  storeId: number;
  store: store;

  subs: Subscription = new Subscription();

  showOrders() {
    this.router.navigate([`store/${this.store.storeId}/orders`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  showInventory() {
    this.router.navigate([`store/${this.store.storeId}/inventory`]).then((e) => {
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
