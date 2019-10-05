package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Location;
import com.revature.models.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
	List<Store> findByLocation(Location location);
}
