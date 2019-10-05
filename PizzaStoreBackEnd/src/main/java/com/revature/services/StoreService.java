package com.revature.services;

import java.util.List;

import com.revature.models.Store;

public interface StoreService {
	public Store createStore(Store store);

	public Store getStoreById(int id);

	public Store updateStore(Store store);

	public Store deleteStore(Store store);
	
	public List<Store> getAllStores();
}
