package com.revature.services;

import java.util.List;

import com.revature.models.Topping;

public interface ToppingService {
	public Topping createTopping(Topping topping);

	public Topping getToppingById(int id);

	public Topping updateTopping(Topping topping);

	public Topping deleteTopping(Topping topping);
	
	public List<Topping> getAllToppings();
}
