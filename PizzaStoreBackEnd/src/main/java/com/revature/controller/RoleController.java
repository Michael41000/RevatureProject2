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


import com.revature.models.Role;

@RequestMapping("roles")
@RestController
@CrossOrigin
public class RoleController {
	 @GetMapping(value="{id}")
	   public Role getRoleById(@PathVariable("id") int id ) {
		   return null;
	   }
	 @GetMapping
	   public List<Role> getRoles() {
		   return null;
	   }
	 @PostMapping(consumes="application/json" )
	   public Role createRole(@RequestBody Role role) {
		   return null;
	   }
	 @PutMapping(value="{id}",consumes="application/json")
	   public Role updateRole(@PathVariable("id") int id,@RequestBody Role role) {
		   role.setRoleId(id);
		   return null;
	   }
	 @DeleteMapping(value="{id}")
	   public void deleteRole(@PathVariable("id")int id) {
		
	   }
}
