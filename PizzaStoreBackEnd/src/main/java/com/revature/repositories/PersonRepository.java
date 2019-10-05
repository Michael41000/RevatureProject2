package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
	Person findByUsernameAndPassword(String username, String password);
}
