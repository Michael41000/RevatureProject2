package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Coupon {
	@Id
	@Column(name = "c_id")
	@SequenceGenerator(sequenceName="coupon_id_maker", name="c_seq")
    @GeneratedValue(generator="c_seq", strategy=GenerationType.SEQUENCE)
	private int coupon_id;
	private double discount_percent;
	private double code;
	private String descriptor;
	
	public Coupon() {
		super();
	}

	public Coupon(int coupon_id, double discount_percent, double code, String descriptor) {
		super();
		this.coupon_id = coupon_id;
		this.discount_percent = discount_percent;
		this.code = code;
		this.descriptor = descriptor;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	public double getDiscount_percent() {
		return discount_percent;
	}

	public void setDiscount_percent(double discount_percent) {
		this.discount_percent = discount_percent;
	}

	public double getCode() {
		return code;
	}

	public void setCode(double code) {
		this.code = code;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public String toString() {
		return "Coupon [coupon_id=" + coupon_id + ", discount_percent=" + discount_percent + ", code=" + code
				+ ", descriptor=" + descriptor + "]";
	} 
}
