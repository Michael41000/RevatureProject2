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

import com.revature.models.PSize;
import com.revature.services.PSizeService;

@RequestMapping("psizes")
@RestController
@CrossOrigin
public class PSizeController {

	@Autowired
	PSizeService pss;

	@GetMapping(value = "{id}")
	public PSize getPSizeById(@PathVariable("id") int id) {
		return pss.getPSizeById(id);
	}

	@GetMapping
	public List<PSize> getPSizes() {
		return pss.getAllPSizes();
	}

	@PostMapping(consumes = "application/json")
	public PSize createPSize(@RequestBody PSize psize) {
		return pss.createPSize(psize);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public PSize updatePSize(@PathVariable("id") int id, @RequestBody PSize psize) {
		psize.setPsizeId(id);
		return pss.updatePSize(psize);
	}

	@DeleteMapping(value = "{id}")
	public PSize deletePSize(@PathVariable("id") int id) {
		return pss.deletePSize(pss.getPSizeById(id));
	}

}
