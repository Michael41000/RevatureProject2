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

import com.revature.models.Role;
import com.revature.services.RoleService;

@RequestMapping("roles")
@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	RoleService rs;

	@GetMapping(value = "{id}")
	public Role getRoleById(@PathVariable("id") int id) {
		return rs.getRoleById(id);
	}

	@GetMapping
	public List<Role> getRoles() {
		return rs.getAllRoles();
	}

	@PostMapping(consumes = "application/json")
	public Role createRole(@RequestBody Role role) {
		return rs.createRole(role);
	}

	@PutMapping(value = "{id}", consumes = "application/json")
	public Role updateRole(@PathVariable("id") int id, @RequestBody Role role) {
		role.setRoleId(id);
		return rs.updateRole(role);
	}

	@DeleteMapping(value = "{id}")
	public Role deleteRole(@PathVariable("id") int id) {
		return rs.deleteRole(rs.getRoleById(id));
	}
}
