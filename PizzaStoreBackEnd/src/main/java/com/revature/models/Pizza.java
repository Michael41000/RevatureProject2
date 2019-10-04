package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pizza {
	@Id
	@Column(name="p_id")
	@SequenceGenerator(sequenceName="pizza_id_maker", name="p_seq")
	@GeneratedValue(generator="p_seq", strategy=GenerationType.SEQUENCE)
	private int pizza_id;
	
	private PSize psize;
	private boolean isSpecialty;
	
	public Pizza() {
		super();
	}

	public Pizza(int pizza_id, PSize psize, boolean isSpecialty) {
		super();
		this.pizza_id = pizza_id;
		this.psize = psize;
		this.isSpecialty = isSpecialty;
	}

	public int getPizza_id() {
		return pizza_id;
	}

	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}

	public PSize getPsize() {
		return psize;
	}

	public void setPsize(PSize psize) {
		this.psize = psize;
	}

	public boolean isSpecialty() {
		return isSpecialty;
	}

	public void setSpecialty(boolean isSpecialty) {
		this.isSpecialty = isSpecialty;
	}

	@Override
	public String toString() {
		return "Pizza [pizza_id=" + pizza_id + ", psize=" + psize + ", isSpecialty=" + isSpecialty + "]";
	}
	
}
