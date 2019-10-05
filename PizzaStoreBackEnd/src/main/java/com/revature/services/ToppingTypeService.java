package com.revature.services;

import java.util.List;

import com.revature.models.ToppingType;

public interface ToppingTypeService {
	public ToppingType createToppingType(ToppingType toppingType);

	public ToppingType getToppingTypeById(int id);

	public ToppingType updateToppingType(ToppingType toppingType);

	public ToppingType deleteToppingType(ToppingType toppingType);
	
	public List<ToppingType> getAllToppingType();
}
