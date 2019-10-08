package com.revature.services;

import java.util.List;

import com.revature.models.Person;

public interface PersonService {
	public Person createPerson(Person person);

	public Person getPersonById(int id);

	public Person updatePerson(Person person);

	public Person deletePerson(Person person);
	
	public List<Person> getAllPerson();

	public Person loginPerson(Person person);
}
