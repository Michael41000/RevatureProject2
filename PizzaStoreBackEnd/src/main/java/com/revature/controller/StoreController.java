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


import com.revature.models.Store;

@RequestMapping("stores")
@RestController
@CrossOrigin
public class StoreController {
	 @GetMapping(value="{id}")
	   public Store getStoreById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<Store> getStores() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public Store createStore(@RequestBody Store store) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public Store updateStore(@PathVariable("id") int id,@RequestBody Store store) {
		   store.setStoreId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deleteStore(@PathVariable("id")int id) {
		
	   }
}
