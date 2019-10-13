import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/service/store.service';
import { ActivatedRoute, Router } from '@angular/router';
import { store } from 'src/app/model/store';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-make-order-store',
  templateUrl: './make-order-store.component.html',
  styleUrls: ['./make-order-store.component.css']
})
export class MakeOrderStoreComponent implements OnInit {

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
  pizzaType: any;
  subs: Subscription = new Subscription();

  selectChangeHandler(event: any) {
    const pizzaOption = event.target.value;
    if (pizzaOption === "storePizza") {
      this.router.navigate([`makeOrder/store/${this.store.storeId}/specialtyPizza`]).then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
    }
    else if (pizzaOption === "customPizza") {
      this.router.navigate([`makeOrder/store/${this.store.storeId}/customPizza`]).then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
    }
  }

  ngOnDestory() {
    this.subs.unsubscribe();
  }

}
