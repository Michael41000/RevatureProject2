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


import com.revature.models.POrder;

@RequestMapping("porders")
@RestController
@CrossOrigin
public class POrderController {
	@GetMapping(value="{id}")
	   public POrder getPOrderById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<POrder> getPOrder() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public POrder createPOrder(@RequestBody POrder porder) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public POrder updatePOrder(@PathVariable("id") int id,@RequestBody POrder porder) {
		   porder.setPorderId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deletePOrder(@PathVariable("id")int id) {
		
	   }
}
