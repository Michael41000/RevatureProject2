package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Store {
	@Id
	@SequenceGenerator(sequenceName="store_id_maker", name="s_seq")
	@GeneratedValue(generator="s_seq", strategy=GenerationType.SEQUENCE)
	@Column(name = "s_id")
	private int store_id;
	private Location location;
	
	public Store() {
		super();
	}

	public Store(int store_id, Location location) {
		super();
		this.store_id = store_id;
		this.location = location;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", location=" + location + "]";
	} 
}
