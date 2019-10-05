package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.ToppingType;

@Repository
public interface ToppingTypeRepository extends CrudRepository<ToppingType, Integer> {
	List<ToppingType> findByType(String type);
}
