import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/service/store.service';
import { Router } from '@angular/router';
import { store } from 'src/app/model/store';
import { GlobalService } from 'src/app/service/global.service';
import { porder } from 'src/app/model/porder';

@Component({
  selector: 'app-make-order-stores',
  templateUrl: './make-order-stores.component.html',
  styleUrls: ['./make-order-stores.component.css']
})
export class MakeOrderStoresComponent implements OnInit {

  constructor(private storeService: StoreService, private router: Router, private globalService: GlobalService) { }

  ngOnInit() {
    this.displayAllStores();
  }

  stores: store[] = [];

  displayAllStores() {
    this.storeService.getAllStores().subscribe(
      (response) => {
        console.log(response);
        this.stores = response;
        console.log(this.stores.length);
      },
      (response) => {

      }
    )
  }

  goToStore(store: store) {
    console.log(store);
    this.globalService.currentOrder = new porder(null, this.globalService.currentPerson, store, null, null, null, []);
    this.router.navigate([`makeOrder/store/${store.storeId}`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });

  }
}
