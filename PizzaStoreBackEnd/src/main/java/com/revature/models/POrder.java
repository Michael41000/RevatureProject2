package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class POrder {
	@Id
	@Column(name="po_id")
	@SequenceGenerator(sequenceName="porder_id_maker", name="po_seq")
	@GeneratedValue(generator="po_seq", strategy=GenerationType.SEQUENCE)
	private int porder_id;
	
	private Person person;
	private Store store;
	private int minutes_to_make;
	
	private Coupon coupon;

	public POrder() {
		super();
	}

	public POrder(int porder_id, Person person, Store store, int minutes_to_make, Coupon coupon) {
		super();
		this.porder_id = porder_id;
		this.person = person;
		this.store = store;
		this.minutes_to_make = minutes_to_make;
		this.coupon = coupon;
	}

	public int getPorder_id() {
		return porder_id;
	}

	public void setPorder_id(int porder_id) {
		this.porder_id = porder_id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getMinutes_to_make() {
		return minutes_to_make;
	}

	public void setMinutes_to_make(int minutes_to_make) {
		this.minutes_to_make = minutes_to_make;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "POrder [porder_id=" + porder_id + ", person=" + person + ", store=" + store + ", minutes_to_make="
				+ minutes_to_make + ", coupon=" + coupon + "]";
	}
}
