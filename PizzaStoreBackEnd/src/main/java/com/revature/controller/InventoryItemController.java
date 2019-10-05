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
import com.revature.models.InventoryItem;

@RestController
@RequestMapping("inventoryitems")
@CrossOrigin
public class InventoryItemController {

	 @GetMapping(value="{id}")
	   public InventoryItem getInventoryItemById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping()
	 public List<InventoryItem> getInventoryItems() {
		 return null;
	 }
	 @PostMapping(consumes="application/json")
	 public InventoryItem createInvenoryItem(@RequestBody InventoryItem inventoryitem) {
		return null;
		 
	 }
	 @PutMapping(value="{id}",consumes="application/json")
	   public InventoryItem updateInventoryItem(@PathVariable("id") int id,@RequestBody InventoryItem inventoryitem) {
		   inventoryitem.setIiId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deleteInventoryItem(@PathVariable("id")int id) {
		
	   }
}
