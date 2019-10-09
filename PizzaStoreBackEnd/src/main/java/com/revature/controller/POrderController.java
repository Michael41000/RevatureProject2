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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.POrder;
import com.revature.models.Person;
import com.revature.services.POrderService;

@RequestMapping("porders")
@RestController
@CrossOrigin
public class POrderController {

	@Autowired
	POrderService pos;

	@GetMapping(value = "{id}")
	public POrder getPOrderById(@PathVariable("id") int id) {
		return pos.getPOrderById(id);
	}

	@GetMapping
	public List<POrder> getPOrder() {
		return pos.findAllPOrders();
	}


	@GetMapping(params = "storeId")
	public List<POrder> showPOrdersByStoreId(@RequestParam("storeId") int storeId){
		return pos.findAllPOrderByStoreId(storeId); 
	}
	
	
	
	@GetMapping(params = "personId")
	public List<POrder> showPOrders(@RequestParam("personId") int personId){
		return pos.customerViewOrders(personId);
	}
	
	@PostMapping(consumes = "application/json")
	public POrder createPOrder(@RequestBody POrder porder) {
		return pos.createPOrder(porder);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public POrder updatePOrder(@PathVariable("id") int id, @RequestBody POrder porder) {
		porder.setPorderId(id);
		return pos.updatePOrder(porder);
	}

	@DeleteMapping(value = "{id}")
	public POrder deletePOrder(@PathVariable("id") int id) {
		return pos.deletePOrder(pos.getPOrderById(id));
	}
}
