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

import com.revature.models.POrder;
import com.revature.models.Store;
import com.revature.services.StoreService;

@RequestMapping("stores")
@RestController
@CrossOrigin
public class StoreController {

	@Autowired
	StoreService ss;

	@GetMapping(value = "{id}")
	public Store getStoreById(@PathVariable("id") int id) {
		return ss.getStoreById(id);
	}

	@GetMapping
	public List<Store> getStores() {
		return ss.getAllStores();
	}

	@PostMapping(consumes = "application/json")
	public Store createStore(@RequestBody Store store) {
		return ss.createStore(store);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Store updateStore(@PathVariable("id") int id, @RequestBody Store store) {
		store.setStoreId(id);
		return ss.updateStore(store);
	}

	@DeleteMapping(value = "{id}")
	public Store deleteStore(@PathVariable("id") int id) {
		return ss.deleteStore(ss.getStoreById(id));
	}
}
