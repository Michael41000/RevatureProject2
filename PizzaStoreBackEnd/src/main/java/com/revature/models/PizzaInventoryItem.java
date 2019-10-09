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
@Table(name = "pizza_inventory_item")
public class PizzaInventoryItem {

	@Id
	@Column(name = "pii_id")
	@SequenceGenerator(sequenceName = "pii_id_maker", name = "pii_seq")
	@GeneratedValue(generator = "pii_seq", strategy = GenerationType.SEQUENCE)
	private int piiId;

	@ManyToOne
	@JoinColumn(name = "ii_id")
	private InventoryItem inventoryItem;

	@ManyToOne
	@JoinColumn(name = "amount")
	private PSize amount;

	public PizzaInventoryItem() {
		super();
	}

	public PizzaInventoryItem(InventoryItem inventoryItem, PSize amount) {
		super();
		this.inventoryItem = inventoryItem;
		this.amount = amount;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public PSize getAmount() {
		return amount;
	}

	public void setAmount(PSize amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PizzaInventoryItem [inventoryItem=" + inventoryItem + ", amount=" + amount + "]";
	}

}
