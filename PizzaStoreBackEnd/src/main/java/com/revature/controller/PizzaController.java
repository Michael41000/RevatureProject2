package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pizza;
import com.revature.services.PizzaService;

@RequestMapping("pizzas")
@RestController
@CrossOrigin
public class PizzaController {

	@Autowired
	PizzaService ps;

	@GetMapping(value = "{id}")
	public Pizza getPizzaById(@PathVariable("id") int id) {
		return ps.getPizzaById(id);
	}

	@GetMapping
	public List<Pizza> getPizzas() {
		System.out.println(ps.getAllPizzas());
		return ps.isSpecialty();
	}
  
	@PostMapping(consumes = "application/json")
	public Pizza createPizza(@RequestBody Pizza pizza) {
		System.out.println(pizza);
		return ps.createPizza(pizza);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Pizza updatePizza(@PathVariable("id") int id, @RequestBody Pizza pizza) {
		pizza.setPizzaId(id);
		return ps.updatePizza(pizza);
	}

	@DeleteMapping(value = "{id}")
	public void deletePizza(@PathVariable("id") int id) {
		ps.deletePizza(ps.getPizzaById(id));
	}
}
