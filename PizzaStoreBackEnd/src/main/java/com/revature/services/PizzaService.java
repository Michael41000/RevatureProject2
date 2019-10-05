package com.revature.services;

import java.util.List;

import com.revature.models.Pizza;

public interface PizzaService {
	public Pizza createPizza(Pizza pizza);

	public Pizza getPizzaById(int id);

	public Pizza updatePizza(Pizza pizza);

	public Pizza deletePizza(Pizza pizza);
	
	public List<Pizza> getAllPizzas();
}
