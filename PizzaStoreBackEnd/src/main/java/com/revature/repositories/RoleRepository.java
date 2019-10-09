package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	Role findByRoleName(String roleName);
}
