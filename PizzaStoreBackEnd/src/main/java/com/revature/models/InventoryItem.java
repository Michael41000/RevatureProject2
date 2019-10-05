package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	@Id
	@Column(name = "inventoyItem_id")
	@SequenceGenerator(sequenceName = "ii_id_maker", name = "ii_seq")
	@GeneratedValue(generator = "ii_seq", strategy = GenerationType.SEQUENCE)
	private int iiId;
	
	@ManyToOne
	@JoinColumn(name="topping_id")
	private Topping topping;
	
	@Column(name="amount_left")
	private int amountLeft;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	public InventoryItem() {
		super();
	}

	public InventoryItem(Topping topping, int amountLeft, double price, Location location, Store store) {
		super();
		this.topping = topping;
		this.amountLeft = amountLeft;
		this.price = price;
		this.location = location;
		this.store = store;
	}

	public InventoryItem(int iiId, Topping topping, int amountLeft, double price, Location location,
			Store store) {
		super();
		this.iiId = iiId;
		this.topping = topping;
		this.amountLeft = amountLeft;
		this.price = price;
		this.location = location;
		this.store = store;
	}

	public int getIiId() {
		return iiId;
	}

	public void setIiId(int iiId) {
		this.iiId = iiId;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public int getAmountLeft() {
		return amountLeft;
	}

	public void setAmountLeft(int amountLeft) {
		this.amountLeft = amountLeft;
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
		return "Inventory_Item [iiId=" + iiId + ", topping=" + topping + ", amountLeft=" + amountLeft
				+ ", price=" + price + ", location=" + location + ", store=" + store + "]";
	}

}
