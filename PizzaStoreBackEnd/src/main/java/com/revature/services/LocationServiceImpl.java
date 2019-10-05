package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Location;
import com.revature.repositories.LocationRepository;

public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository lr;
	
	@Override
	public Location createLocation(Location location) {
		lr.save(location);
		return location;
	}

	@Override
	public Location getLocationById(int id) {
		return lr.findById(id).get();
	}

	@Override
	public Location updateLocation(Location location) {
		lr.save(location);
		return location;
	}

	@Override
	public Location deleteLocation(Location location) {
		lr.delete(location);
		return location;
	}

	@Override
	public List<Location> getAllLocation() {
		return  (List<Location>)lr.findAll();
	}

}
