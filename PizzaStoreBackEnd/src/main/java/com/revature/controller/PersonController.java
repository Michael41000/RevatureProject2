package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Coupon;
import com.revature.models.Person;

@RestController
@CrossOrigin
@RequestMapping("persons")
public class PersonController {
	 @GetMapping(value="{id}")
	   public Person getPersonById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<Person> getPersons() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public Person createPerson(@RequestBody Person person) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public Person updatePerson(@PathVariable("id") int id,@RequestBody Person person) {
		   person.setPersonId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deletePerson(@PathVariable("id")int id) {
		
	   }
}
