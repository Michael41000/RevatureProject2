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

import com.revature.models.Topping;
import com.revature.services.ToppingService;

@RequestMapping("toppings")
@RestController
@CrossOrigin
public class ToppingController {

	@Autowired
	ToppingService ts;

	@GetMapping(value = "{id}")
	public Topping getToppingById(@PathVariable("id") int id) {
		return ts.getToppingById(id);
	}

	@GetMapping
	public List<Topping> getToppings() {
		return ts.getAllToppings();
	}

	@PostMapping(consumes = "application/json")
	public Topping createTopping(@RequestBody Topping topping) {
		return ts.createTopping(topping);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Topping updateTopping(@PathVariable("id") int id, @RequestBody Topping topping) {
		topping.setToppingId(id);
		return ts.updateTopping(topping);
	}

	@DeleteMapping(value = "{id}")
	public Topping deleteTopping(@PathVariable("id") int id) {
		return ts.deleteTopping(ts.getToppingById(id));
	}

}
