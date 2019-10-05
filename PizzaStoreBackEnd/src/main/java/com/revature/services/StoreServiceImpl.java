package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Store;
import com.revature.repositories.StoreRepository;

public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository sr;
	
	@Override
	public Store createStore(Store store) {
		sr.save(store);
		return store;
	}

	@Override
	public Store getStoreById(int id) {
		return sr.findById(id).get();
	}

	@Override
	public Store updateStore(Store store) {
		sr.save(store);
		return store;
	}

	@Override
	public Store deleteStore(Store store) {
		sr.delete(store);
		return store;
	}

	@Override
	public List<Store> getAllStores() {
		return (List<Store>) sr.findAll();
	}

}
