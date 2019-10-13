import { Component, OnInit } from '@angular/core';
import { CouponService } from 'src/app/service/coupon.service';
import { coupon } from 'src/app/model/coupon';
import { Subscription } from 'rxjs';
import { GlobalService } from 'src/app/service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-coupon',
  templateUrl: './add-coupon.component.html',
  styleUrls: ['./add-coupon.component.css']
})
export class AddCouponComponent implements OnInit {

  constructor(private couponService: CouponService,
    private globalService: GlobalService,
    private router: Router) { }

  ngOnInit() {
    this.getCoupons();
  }

  coupons: coupon[];
  discountPercent: number;
  code: number;
  description: string;
  subs: Subscription = new Subscription();

  getCoupons() {
    this.subs.add(this.couponService.getActiveCoupons().subscribe(
      (response) => {
        console.log(response)
        this.coupons = response;
      }
    ));
  }

  addCouponToOrder(coupon: coupon) {
    this.globalService.currentOrder.coupon = coupon;
    this.router.navigate([`makeOrder/currentOrder`]).then((e) => {
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
