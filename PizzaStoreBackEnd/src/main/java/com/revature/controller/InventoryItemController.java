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

import com.revature.models.InventoryItem;
import com.revature.models.Store;
import com.revature.services.InventoryItemService;

@RestController
@RequestMapping("inventoryitems")
@CrossOrigin
public class InventoryItemController {

	@Autowired
	InventoryItemService iis;

	@GetMapping(value = "{id}")
	public InventoryItem getInventoryItemById(@PathVariable("id") int id) {
		return iis.getInventoryItemById(id);
	}

	@GetMapping()
	public List<InventoryItem> getInventoryItems() {
		return iis.getAllInventoryItems();
	}
	
	@GetMapping(params = "store")
	public List<InventoryItem> getInventoryItemsByStore(@RequestParam("store") int storeId) {
		return iis.getInventoryItemsByStoreId(storeId);
	}

	@PostMapping(consumes = "application/json")
	public InventoryItem createInvenoryItem(@RequestBody InventoryItem inventoryitem) {
		return iis.createInventoryItem(inventoryitem);

	}
	
	@GetMapping(params = "storeId")
	public List<InventoryItem> showInventoryItems(@RequestParam("storeId") int storeId){
		return iis.getInventoryItemsByStoreStoreId(storeId);
	}
	
//	@PostMapping(value = "showII", consumes = "application/json")
//	public List<InventoryItem> showInventoryItems(@RequestBody Store store){
//		return iis.getInventoryItemsByStore(store);
//	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public InventoryItem updateInventoryItem(@PathVariable("id") int id, @RequestBody InventoryItem inventoryitem) {
		inventoryitem.setIiId(id);
		return iis.updateInventoryItem(inventoryitem);
	}

	@DeleteMapping(value = "{id}")
	public InventoryItem deleteInventoryItem(@PathVariable("id") int id) {
		return iis.deleteInventoryItem(iis.getInventoryItemById(id));
	}
}
