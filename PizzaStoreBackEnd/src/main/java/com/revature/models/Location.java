package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@Column(name = "l_id")
	@SequenceGenerator(sequenceName = "location_id_maker", name = "l_seq")
	@GeneratedValue(generator = "l_seq", strategy = GenerationType.SEQUENCE)
	private int locationId;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "name")
	private String name;

	public Location() {
		super();
	}

	public Location(double latitude, double longitude, String name) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}

	public Location(int locationId, double latitude, double longitude, String name) {
		super();
		this.locationId = locationId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", latitude=" + latitude + ", longitude=" + longitude + ", name="
				+ name + "]";
	}

}
