package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer>{
	List<Pizza> findByIsSpecialty(boolean isSpecialty); 
	
	List<Pizza> findAllByIsSpecialtyTrue();
}
