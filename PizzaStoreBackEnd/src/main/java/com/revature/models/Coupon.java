package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	@Column(name = "c_id")
	@SequenceGenerator(sequenceName = "coupon_id_maker", name = "c_seq", allocationSize = 1)
	@GeneratedValue(generator = "c_seq", strategy = GenerationType.SEQUENCE)
	private int couponId;
	
	@Column(name = "discount_percent")
	private double discountPercent;
	
	@Column(name="code")
	private double code;
	
	@Column(name="description")
	private String description;
	
	@Type(type = "true_false")
	@Column(name = "active", nullable = false)
	private boolean active;

	public Coupon() {
		super();
	}

	public Coupon(double discountPercent, double code, String description, boolean active) {
		super();
		this.discountPercent = discountPercent;
		this.code = code;
		this.description = description;
		this.active = active;
	}

	public Coupon(int couponId, double discountPercent, double code, String description, boolean active) {
		super();
		this.couponId = couponId;
		this.discountPercent = discountPercent;
		this.code = code;
		this.description = description;
		this.active = active;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getCode() {
		return code;
	}

	public void setCode(double code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", discountPercent=" + discountPercent + ", code=" + code +
				", description=" + description + ", active=" + active + "]";
	}


	
}
