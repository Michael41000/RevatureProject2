package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "r_id")
	@SequenceGenerator(sequenceName = "role_id_maker", name = "r_seq")
	@GeneratedValue(generator = "r_seq", strategy = GenerationType.SEQUENCE)
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;

	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
