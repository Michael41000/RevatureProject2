package com.revature.services;

import java.util.List;

import com.revature.models.InventoryItem;
import com.revature.models.Store;

public interface InventoryItemService {
	public InventoryItem createInventoryItem(InventoryItem inventoryItem);

	public InventoryItem getInventoryItemById(int id);

	public InventoryItem updateInventoryItem(InventoryItem inventoryItem);

	public InventoryItem deleteInventoryItem(InventoryItem inventoryItem);
	
	public List<InventoryItem> getAllInventoryItems();
	
	public List<InventoryItem> getInventoryItemsByStore(Store store);

	public List<InventoryItem> getInventoryItemsByStoreId(int storeId);
	public List<InventoryItem> getInventoryItemsByStoreStoreId(int storeId);
}
