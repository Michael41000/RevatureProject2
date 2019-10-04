package com.revature.models;

import javax.persistence.Entity;

@Entity
public class POrder_Pizza {
	private POrder porder;
	private Pizza pizza;
	
	public POrder_Pizza() {
		super();
	}

	public POrder_Pizza(POrder porder, Pizza pizza) {
		super();
		this.porder = porder;
		this.pizza = pizza;
	}

	public POrder getPorder() {
		return porder;
	}

	public void setPorder(POrder porder) {
		this.porder = porder;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "POrder_Pizza [pizza=" + pizza + "]";
	}
	
}
