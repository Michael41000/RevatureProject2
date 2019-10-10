import { Component, OnInit } from '@angular/core';
import { CouponService } from 'src/app/service/coupon.service';
import { coupon } from 'src/app/model/coupon';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-coupons',
  templateUrl: './coupons.component.html',
  styleUrls: ['./coupons.component.css']
})
export class CouponsComponent implements OnInit {

  constructor(private couponService: CouponService) { }

  ngOnInit() {
    this.getCoupons();
  }

  coupons: coupon[];
  discountPercent: number;
  code: number;
  description: string;
  subs: Subscription = new Subscription();

  getCoupons() {
    this.subs.add(this.couponService.getCoupons().subscribe(
      (response) => {
        console.log(response)
        this.coupons = response;
      }
    ));
  }

  createCoupon() {
    console.log(this.discountPercent);
    console.log(this.code);
    console.log(this.description);
    if (this.discountPercent !== undefined && this.code !== undefined && this.description !== undefined &&
      this.discountPercent !== null && this.code !== null && this.description !== "") {
      const newCoupon = new coupon(null, this.discountPercent, this.code, this.description, true);
      console.log(newCoupon);
      this.subs.add(this.couponService.createCoupon(newCoupon).subscribe(
        (response) => {
          console.log(response);
          this.getCoupons();
        }
      ));
    }
  }

  deactivate(coupon: coupon) {
    coupon.active = false;
    this.subs.add(this.couponService.updateCoupon(coupon).subscribe(
      (response) => {
        console.log(response);
      }
    ));
  }

  activate(coupon: coupon) {
    coupon.active = true;
    this.subs.add(this.couponService.updateCoupon(coupon).subscribe(
      (response) => {
        console.log(response);
      }
    ));
  }

  ngOnDestory() {
    this.subs.unsubscribe();
  }

}
