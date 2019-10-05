package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Coupon;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer>{
	List<Coupon> findByCode(double code);
	
}
