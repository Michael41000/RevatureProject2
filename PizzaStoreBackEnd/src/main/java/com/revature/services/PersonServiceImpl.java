package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Person;
import com.revature.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personr;
	
	@Override
	public Person createPerson(Person person) {
		personr.save(person);
		return person;
	}

	@Override
	public Person getPersonById(int id) {
		return personr.findById(id).get();
	}

	@Override
	public Person updatePerson(Person person) {
		personr.save(person);
		return person;
	}

	@Override
	public Person deletePerson(Person person) {
		personr.delete(person);
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		return (List<Person>) personr.findAll();
	}

}
