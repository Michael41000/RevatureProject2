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
	@Autowired
	RoleService rs;
	
	@Override
	public Person createPerson(Person person) {
		System.out.println(person);
		person.setRole(rs.getRoleByName("Customer"));
		
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

	@Override
	public void testCheckUsername(String username) {
		// TODO Auto-generated method stub
		if (personr.checkUsername(username)) {
			System.out.println("username good");
		}
		else {
			System.out.println("username bad");
		}
  }
  
  @Override
	public Person loginPerson(Person person) {
		return personr.findByUsernameAndPassword(person.getUsername(), person.getPassword());
	}

}
