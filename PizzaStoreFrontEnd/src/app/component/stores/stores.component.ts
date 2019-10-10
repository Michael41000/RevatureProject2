import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/service/store.service';
import { store } from 'src/app/model/store';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stores',
  templateUrl: './stores.component.html',
  styleUrls: ['./stores.component.css']
})
export class StoresComponent implements OnInit {

  constructor(private storeService: StoreService, private router: Router) { }

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
    this.router.navigate([`store/${store.storeId}`]).then( (e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

}
