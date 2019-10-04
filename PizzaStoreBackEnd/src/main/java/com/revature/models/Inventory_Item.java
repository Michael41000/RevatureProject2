package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Inventory_Item {
	@Id
	@Column(name = "inventoyItem_id")
	@SequenceGenerator(sequenceName="ii_id_maker", name="ii_seq")
    @GeneratedValue(generator="ii_seq", strategy=GenerationType.SEQUENCE)
	private int ii_id;
	private Topping_Type topping_type;
	private int amount_left;
	private double price;
	private Location location;
	private Store store;
	
	public Inventory_Item() {
		super();
	}

	public Inventory_Item(int ii_id, Topping_Type topping_type, int amount_left, double price, Location location,
			Store store) {
		super();
		this.ii_id = ii_id;
		this.topping_type = topping_type;
		this.amount_left = amount_left;
		this.price = price;
		this.location = location;
		this.store = store;
	}

	public int getIi_id() {
		return ii_id;
	}

	public void setIi_id(int ii_id) {
		this.ii_id = ii_id;
	}

	public Topping_Type getTopping_type() {
		return topping_type;
	}

	public void setTopping_type(Topping_Type topping_type) {
		this.topping_type = topping_type;
	}

	public int getAmount_left() {
		return amount_left;
	}

	public void setAmount_left(int amount_left) {
		this.amount_left = amount_left;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "Inventory_Item [ii_id=" + ii_id + ", topping_type=" + topping_type + ", amount_left=" + amount_left
				+ ", price=" + price + ", location=" + location + ", store=" + store + "]";
	}
}
