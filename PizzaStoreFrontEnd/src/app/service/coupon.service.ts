import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { coupon } from '../model/coupon';
import { person } from '../model/person';
import { GlobalService } from './global.service';

@Injectable({
  providedIn: 'root'
})
export class CouponService {

  constructor(private http : HttpClient, private globalService: GlobalService) { }

  getCoupons() : Observable<coupon[]> {
    return this.http.get<coupon[]>(`${this.globalService.hostName}/coupons`);
  };

  createCoupon(coupon: coupon) : Observable<coupon> {
    return this.http.post<coupon>(`${this.globalService.hostName}/coupons`, coupon);
  }

  updateCoupon(coupon: coupon) : Observable<coupon> {
    return this.http.put<coupon>(`${this.globalService.hostName}/coupons/${coupon.couponId}`, coupon)
  }

  getActiveCoupons() : Observable<coupon[]> {
    return this.http.get<coupon[]>(`${this.globalService.hostName}/coupons/active`)
  }
}
