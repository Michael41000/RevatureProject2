import { Component, OnInit } from '@angular/core';
import { GlobalService } from 'src/app/service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-make-order',
  templateUrl: './make-order.component.html',
  styleUrls: ['./make-order.component.css']
})
export class MakeOrderComponent implements OnInit {

  constructor(private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    console.log("In makeorder init");
    console.log(this.globalService.currentOrder === undefined);
    // Go to stores page to make new order
    if (this.globalService.currentOrder === undefined) {
      this.router.navigate([`makeOrder/stores`]).then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
    }
    // Go to currentOrder page to see current order
    else {
      this.router.navigate([`makeOrder/currentOrder`]).then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
    }
  }

}
