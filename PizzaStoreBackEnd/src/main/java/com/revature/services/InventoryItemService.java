package com.revature.services;

import java.util.List;


import com.revature.models.InventoryItem;

public interface InventoryItemService {
	public InventoryItem createInventoryItem(InventoryItem inventoryItem);

	public InventoryItem getInventoryItemById(int id);

	public InventoryItem updateInventoryItem(InventoryItem inventoryItem);

	public InventoryItem deleteInventoryItem(InventoryItem inventoryItem);
	
	public List<InventoryItem> getAllInventoryItems();
}
