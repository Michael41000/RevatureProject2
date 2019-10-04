package com.revature.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Location {
	@Id
	@Column(name = "l_id")
	@SequenceGenerator(sequenceName="location_id_maker", name="l_seq")
    @GeneratedValue(generator="l_seq", strategy=GenerationType.SEQUENCE)
	private int location_id;
	private double latitude;
	private double longitude; 
	private String name;
	
	public Location() {
		super();
	}
	
	public Location(int location_id, double latitude, double longitude, String name) {
		super();
		this.location_id = location_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
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
		return "Location [location_id=" + location_id + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
				+ "]";
	}

}
