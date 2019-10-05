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


import com.revature.models.Topping;

@RequestMapping("toppings")
@RestController
@CrossOrigin
public class ToppingController {
	 @GetMapping(value="{id}")
	   public Topping getToppingById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<Topping> getToppings() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public Topping createTopping(@RequestBody Topping topping) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public 	Topping  updateTopping(@PathVariable("id") int id,@RequestBody Topping topping) {
		   topping.setToppingId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deleteTopping(@PathVariable("id")int id) {
		
	   }

}
