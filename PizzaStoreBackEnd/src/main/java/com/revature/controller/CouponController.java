package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Coupon;
import com.revature.services.CouponService;

@RestController
@RequestMapping("coupons")
@CrossOrigin
public class CouponController {

	@Autowired
	CouponService cs;

	@GetMapping(value = "{id}")
	public Coupon getCouponById(@PathVariable("id") int id) {
		return cs.getCouponById(id);
	}

	@GetMapping
	public List<Coupon> getCoupons() {
		return cs.getAllCoupons();
	}
	
	@GetMapping(value = "active")
	public List<Coupon> getActiveCoupons() {
		return cs.getActiveCoupons();
	}

	@PostMapping(consumes = "application/json")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		System.out.println(coupon);
		return cs.createCoupon(coupon);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Coupon updateCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon) {
		coupon.setCouponId(id);
		return cs.updateCoupon(coupon);
	}

	@DeleteMapping(value = "{id}")
	public Coupon deleteCoupon(@PathVariable("id") int id) {
		return cs.deleteCoupon(cs.getCouponById(id));
	}

}
