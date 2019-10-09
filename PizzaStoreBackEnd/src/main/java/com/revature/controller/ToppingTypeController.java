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

import com.revature.models.ToppingType;
import com.revature.services.ToppingTypeService;

@RequestMapping("toppingtypes")
@RestController
@CrossOrigin
public class ToppingTypeController {

	@Autowired
	ToppingTypeService tts;

	@GetMapping(value = "{id}")
	public ToppingType getToppingTypeById(@PathVariable("id") int id) {
		return tts.getToppingTypeById(id);
	}

	@GetMapping
	public List<ToppingType> getToppingTypes() {
		return tts.getAllToppingType();
	}

	@PostMapping(consumes = "application/json")
	public ToppingType createToppingType(@RequestBody ToppingType toppingtype) {
		return tts.createToppingType(toppingtype);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public ToppingType updateToppingType(@PathVariable("id") int id, @RequestBody ToppingType toppingtype) {
		toppingtype.setTtId(id);
		return tts.updateToppingType(toppingtype);
	}

	@DeleteMapping(value = "{id}")
	public ToppingType deleteToppingType(@PathVariable("id") int id) {
		return tts.deleteToppingType(tts.getToppingTypeById(id));
	}

}
