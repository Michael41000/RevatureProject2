package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {
	@Id
	@SequenceGenerator(sequenceName = "store_id_maker", name = "s_seq")
	@GeneratedValue(generator = "s_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "s_id")
	private int storeId;

	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Store() {
		super();
	}

	public Store(Location location) {
		super();
		this.location = location;
	}

	public Store(int storeId, Location location) {
		super();
		this.storeId = storeId;
		this.location = location;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", location=" + location + "]";
	}

}
