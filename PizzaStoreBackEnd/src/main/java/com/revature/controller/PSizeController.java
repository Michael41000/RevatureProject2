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

import com.revature.models.Coupon;
import com.revature.models.PSize;

@RequestMapping("psizes")
@RestController
@CrossOrigin
public class PSizeController {
	 @GetMapping(value="{id}")
	   public PSize getPSizeById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<PSize> getPSizes() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public PSize createPSize(@RequestBody PSize psize) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public PSize updatePSize(@PathVariable("id") int id,@RequestBody PSize psize) {
		   psize.setPsizeId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deletePSize(@PathVariable("id")int id) {
		
	   }

}
