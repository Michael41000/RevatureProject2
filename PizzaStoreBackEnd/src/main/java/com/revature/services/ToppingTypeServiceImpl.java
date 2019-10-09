package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.ToppingType;
import com.revature.repositories.ToppingTypeRepository;

@Service
public class ToppingTypeServiceImpl implements ToppingTypeService {

	@Autowired
	ToppingTypeRepository toppingtyper;
	

	@Override
	public ToppingType createToppingType(ToppingType toppingType) {
		toppingtyper.save(toppingType);
		return toppingType;
	}

	@Override
	public ToppingType getToppingTypeById(int id) {
		return toppingtyper.findById(id).get();
	}

	@Override
	public ToppingType updateToppingType(ToppingType toppingType) {
		toppingtyper.save(toppingType);
		return toppingType;
	}

	@Override
	public ToppingType deleteToppingType(ToppingType toppingType) {
		toppingtyper.delete(toppingType);
		return toppingType;
	}

	@Override
	public List<ToppingType> getAllToppingType() {
		return (List<ToppingType>) toppingtyper.findAll();
	}

}
