package com.revature.services;

import java.util.List;

import com.revature.models.Coupon;

public interface CouponService {
	public Coupon createCoupon(Coupon coupon);

	public Coupon getCouponById(int id);
	
	public List<Coupon> getAllCoupons();

	public Coupon updateCoupon(Coupon coupon);

	public Coupon deleteCoupon(Coupon coupon);
}
