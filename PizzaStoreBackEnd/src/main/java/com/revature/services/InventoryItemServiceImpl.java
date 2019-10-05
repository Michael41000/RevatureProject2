package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.InventoryItem;
import com.revature.repositories.InventoryItemRepository;

public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	InventoryItemRepository iir;
	
	@Override
	public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
		iir.save(inventoryItem);
		return inventoryItem;
	}

	@Override
	public InventoryItem getInventoryItemById(int id) {
		return iir.findById(id).get();
	}

	@Override
	public InventoryItem updateInventoryItem(InventoryItem inventoryItem) {
		iir.save(inventoryItem);
		return inventoryItem;
	}

	@Override
	public InventoryItem deleteInventoryItem(InventoryItem inventoryItem) {
		iir.delete(inventoryItem);
		return inventoryItem;
	}

	@Override
	public List<InventoryItem> getAllInventoryItems() {
		// TODO Auto-generated method stub
		return (List<InventoryItem>) iir.findAll();
	}

}
