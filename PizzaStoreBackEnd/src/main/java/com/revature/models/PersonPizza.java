package com.revature.models;

import javax.persistence.Entity;

@Entity
public class PersonPizza {
	
	private Person person;
	private Pizza pizza;
	
	public PersonPizza() {
		super();
	}

	public PersonPizza(Person person, Pizza pizza) {
		super();
		this.person = person;
		this.pizza = pizza;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "PersonPizza [person=" + person + ", pizza=" + pizza + "]";
	}
	
}
