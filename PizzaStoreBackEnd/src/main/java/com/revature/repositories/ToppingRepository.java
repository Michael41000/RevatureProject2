package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Topping;

@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer> {
	List<Topping> findByToppingName(String toppingName);
}
