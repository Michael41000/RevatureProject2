package com.revature.controller;

import java.util.List;

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

import com.revature.models.Location;
import com.revature.services.LocationService;

@RequestMapping("locations")
@RestController
@CrossOrigin
public class LocationController {

	@Autowired
	LocationService ls;

	@GetMapping(value = "{id}")
	public Location getLocationById(@PathVariable("id") int id) {
		return ls.getLocationById(id);
	}

	@GetMapping
	public List<Location> getLocations() {
		return ls.getAllLocation();
	}

	@PostMapping(consumes = "application/json")
	public Location createLocation(@RequestBody Location location) {
		return ls.createLocation(location);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Location updateLocation(@PathVariable("id") int id, @RequestBody Location location) {
		location.setLocationId(id);
		return ls.updateLocation(location);
	}

	@DeleteMapping(value = "{id}")
	public Location deleteLocation(@PathVariable("id") int id) {
		return ls.deleteLocation(ls.getLocationById(id));
	}
}
