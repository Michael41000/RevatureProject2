package com.revature.models;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Id
	@Column(name = "p_id")
	@SequenceGenerator(sequenceName = "pizza_id_maker", name = "p_seq")
	@GeneratedValue(generator = "p_seq", strategy = GenerationType.SEQUENCE)
	private int pizzaId;

	@ManyToOne
	@JoinColumn(name = "psize_id")
	private PSize psize;

	@Type(type = "true_false")
	@Column(name = "is_specialty", nullable = false)
	private boolean isSpecialty;

	@OneToMany
	@JoinColumn(name = "pizza_id")
	private List<PizzaInventoryItem> inventoryItems;

	public Pizza() {
		super();
	}

	public Pizza(PSize psize, boolean isSpecialty, List<PizzaInventoryItem> inventoryItems) {
		super();
		this.psize = psize;
		this.isSpecialty = isSpecialty;
		this.inventoryItems = inventoryItems;
	}

	public Pizza(int pizzaId, PSize psize, boolean isSpecialty, List<PizzaInventoryItem> inventoryItems) {
		super();
		this.pizzaId = pizzaId;
		this.psize = psize;
		this.isSpecialty = isSpecialty;
		this.inventoryItems = inventoryItems;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public PSize getPsize() {
		return psize;
	}

	public void setPsize(PSize psize) {
		this.psize = psize;
	}

	public boolean isSpecialty() {
		return isSpecialty;
	}

	public void setSpecialty(boolean isSpecialty) {
		this.isSpecialty = isSpecialty;
	}

	public List<PizzaInventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<PizzaInventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", psize=" + psize + ", isSpecialty=" + isSpecialty + ", inventoryItems=" +
				inventoryItems + "]";
	}

}
