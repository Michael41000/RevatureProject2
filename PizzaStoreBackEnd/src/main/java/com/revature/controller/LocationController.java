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


import com.revature.models.Location;

@RequestMapping("locations")
@RestController
@CrossOrigin
public class LocationController {
	  @GetMapping(value="{id}")
	   public Location getLocationById(@PathVariable("id") int id ) {
		   return null;
	   }
	  @GetMapping
	   public List<Location> getLocations() {
		   return null;
	   }
	  @PostMapping(consumes="application/json" )
	   public Location createLocation(@RequestBody Location location) {
		   return null;
	   }
	  @PutMapping(value="{id}",consumes="application/json")
	   public Location updateLocation(@PathVariable("id") int id,@RequestBody Location location) {
		   location.setLocationId(id);
		   return null;
	   }
	  
	  @DeleteMapping(value="{id}")
	   public void deleteLocation(@PathVariable("id")int id) {
		
	   }
}
