package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository rr;
	
	
	@Override
	public Role createRole(Role role) {
		rr.save(role);
		return role;
	}

	@Override
	public Role getRoleById(int id) {
		return rr.findById(id).get();
	}

	@Override
	public Role updateRole(Role role) {
		rr.save(role);
		return role;
	}

	@Override
	public Role deleteRole(Role role) {
		rr.delete(role);
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) rr.findAll();
	}
}
