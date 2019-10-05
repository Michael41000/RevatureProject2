package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Coupon;

@RestController
@RequestMapping("coupons")
@CrossOrigin
public class CouponController {
   @GetMapping(value="{id}")
   public Coupon getCouponById(@PathVariable("id") int id ) {
	   return null;
   }
   @GetMapping
   public List<Coupon> getCoupons() {
	   return null;
   }
   @PostMapping(consumes="application/json" )
   public Coupon createCoupon(@RequestBody Coupon coupon) {
	   return null;
   }
   @PutMapping(value="{id}",consumes="application/json")
   public Coupon updateCoupon(@PathVariable("id") int id,@RequestBody Coupon coupon) {
	   coupon.setCouponId(id);
	   return null;
   }
   @DeleteMapping(value="{id}")
   public void deleteCoupon(@PathVariable("id")int id) {
	
   }
   
 
   
}
