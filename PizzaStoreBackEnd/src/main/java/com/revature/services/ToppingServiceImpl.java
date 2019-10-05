package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Topping;
import com.revature.repositories.ToppingRepository;

@Service
public class ToppingServiceImpl implements ToppingService {

	
	@Autowired
	ToppingRepository toppingr;
	
	@Override
	public Topping createTopping(Topping topping) {
		toppingr.save(topping);
		return topping;
	}

	@Override
	public Topping getToppingById(int id) {
		return toppingr.findById(id).get();
	}

	@Override
	public Topping updateTopping(Topping topping) {
		toppingr.save(topping);
		return topping;
	}

	@Override
	public Topping deleteTopping(Topping topping) {
		toppingr.delete(topping);
		return topping;
	}

	@Override
	public List<Topping> getAllToppings() {
		return (List<Topping>) toppingr.findAll();
	}

}
