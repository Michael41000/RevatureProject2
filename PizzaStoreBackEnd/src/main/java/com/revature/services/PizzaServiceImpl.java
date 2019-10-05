package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Pizza;
import com.revature.repositories.PizzaRepository;

public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaRepository pizzar;
	
	@Override
	public Pizza createPizza(Pizza pizza) {
		pizzar.save(pizza);
		return pizza;
	}

	@Override
	public Pizza getPizzaById(int id) {
		return pizzar.findById(id).get();
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {
		pizzar.save(pizza);
		return pizza;
	}

	@Override
	public Pizza deletePizza(Pizza pizza) {
		pizzar.delete(pizza);
		return pizza;
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return (List<Pizza>) pizzar.findAll();
	}

}
