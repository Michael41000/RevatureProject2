package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.POrder;
import com.revature.models.Person;
import com.revature.models.Store;

@Repository
public interface POrderRepository extends CrudRepository<POrder, Integer>{
	List<POrder> findByPerson(Person person);
	List<POrder> findByStore(Store store);
	
	List<POrder> findAllByPerson(Person person);
}
