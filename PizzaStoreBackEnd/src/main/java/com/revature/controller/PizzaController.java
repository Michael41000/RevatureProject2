package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Coupon;
import com.revature.models.Pizza;

@RequestMapping("pizzas")
@RestController
@CrossOrigin
public class PizzaController {
	 @GetMapping(value="{id}")
	   public Pizza getPizzaById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<Pizza> getPizzas() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public Pizza createPizza(@RequestBody Pizza pizza) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public Pizza updatePizza(@PathVariable("id") int id,@RequestBody Pizza pizza) {
		   pizza.setPizzaId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deletePizza(@PathVariable("id")int id) {
		
	   }
}
