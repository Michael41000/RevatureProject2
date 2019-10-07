package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
	Person findByUsernameAndPassword(String username, String password);
	
	boolean existsByUsername(String username);
	
	default boolean checkUsername(String username) {
		/*
		 * This method is used for verifying that the username in which the
		 * user would like to create an account with is not already taken;
		 * to comply with the unique constraint on the username for a person.
		 * 
		 * PARAMETERS:
		 * 		username: a string that needs to be unique in the
		 * 				  person table; need to check if in
		 * 				  compliance with unique constraint.
		 * 
		 * RETURNS:
		 * 		a boolean which shows whether or not the username is
		 * 		available to create an account with.
		 */
		if (existsByUsername(username)) {
			return false;
		}
		return true;
	}
}
