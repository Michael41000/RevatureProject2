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


import com.revature.models.ToppingType;

@RequestMapping("toppingtypes")
@RestController
@CrossOrigin
public class ToppingTypeController {
	 @GetMapping(value="{id}")
	   public ToppingType getToppingTypeById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<ToppingType> getToppingTypes() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public ToppingType createToppingType(@RequestBody ToppingType toppingtype) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public ToppingType updateToppingType(@PathVariable("id") int id,@RequestBody ToppingType toppingtype) {
		   toppingtype.setTtId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deleteToppingType(@PathVariable("id")int id) {
		
	   }
	   
}
