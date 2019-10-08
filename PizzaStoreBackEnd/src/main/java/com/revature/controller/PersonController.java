package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Person;
import com.revature.services.PersonService;

@RestController
@CrossOrigin
@RequestMapping("persons")
public class PersonController {

	@Autowired
	PersonService ps;

	@GetMapping(value = "{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		return ps.getPersonById(id);
	}

	@GetMapping
	public List<Person> getPersons() {
		return ps.getAllPerson();
	}

	@PostMapping(consumes = "application/json")
	public Person createPerson(@RequestBody Person person) {
		return ps.createPerson(person);
	}
	
	@PostMapping(value = "login", consumes = "application/json")
	public Person loginPerson(@RequestBody Person person, HttpServletResponse response) {
		Person loginPerson = ps.loginPerson(person);
		if (loginPerson == null) {
			response.setStatus(422);
		}
		return loginPerson;
		
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Person updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
		person.setPersonId(id);
		return ps.updatePerson(person);
	}

	@DeleteMapping(value = "{id}")
	public Person deletePerson(@PathVariable("id") int id) {
		return ps.deletePerson(ps.getPersonById(id));
	}
}
