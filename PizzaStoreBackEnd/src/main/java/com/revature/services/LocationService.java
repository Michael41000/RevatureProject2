package com.revature.services;

import java.util.List;

import com.revature.models.Location;

public interface LocationService {
	public Location createLocation(Location location);

	public Location getLocationById(int id);

	public Location updateLocation(Location location);

	public Location deleteLocation(Location location);
	
	public List<Location> getAllLocation();
}
