package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.InventoryItem;
import com.revature.models.Location;
import com.revature.models.Store;
import com.revature.models.Topping;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer>{
	List<Location> findByLocation(Location location);
	List<InventoryItem> findAllByStore(Store store); 
	List<Topping> findByTopping(Topping topping);
}
