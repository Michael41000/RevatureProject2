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
@Table(name = "topping")
public class Topping {
	@Id
	@Column(name = "t_id")
	@SequenceGenerator(sequenceName = "topping_id_maker", name = "topping_seq")
	@GeneratedValue(generator = "topping_seq", strategy = GenerationType.SEQUENCE)
	private int toppingId;

	@Column(name = "name")
	private String toppingName;

	@Column(name = "calories")
	private double calories;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private ToppingType type;

	public Topping() {
		super();
	}

	public Topping(String toppingName, double calories, ToppingType type) {
		super();
		this.toppingName = toppingName;
		this.calories = calories;
		this.type = type;
	}

	public Topping(int toppingId, String toppingName, double calories, ToppingType type) {
		super();
		this.toppingId = toppingId;
		this.toppingName = toppingName;
		this.calories = calories;
		this.type = type;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public ToppingType getType() {
		return type;
	}

	public void setType(ToppingType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Topping [toppingId=" + toppingId + ", toppingName=" + toppingName + ", calories=" + calories + ", type="
				+ type + "]";
	}

}
