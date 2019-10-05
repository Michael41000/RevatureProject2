package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Coupon;
import com.revature.repositories.CouponRepository;

public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponRepository cr;
	
	@Override
	public Coupon createCoupon(Coupon coupon) {
		cr.save(coupon);
		return coupon;
	}

	@Override
	public Coupon getCouponById(int id) {
		return cr.findById(id).get();
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		cr.save(coupon);
		return coupon;
	}

	@Override
	public Coupon deleteCoupon(Coupon coupon) {
		cr.delete(coupon);
		return coupon;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		return (List<Coupon>) cr.findAll();
	}

}
