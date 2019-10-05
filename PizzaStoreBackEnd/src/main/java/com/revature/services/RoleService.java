package com.revature.services;

import java.util.List;

import com.revature.models.Role;

public interface RoleService {
	public Role createRole(Role role);

	public Role getRoleById(int id);

	public Role updateRole(Role role);

	public Role deleteRole(Role role);
	
	public List<Role> getAllRoles();
}
