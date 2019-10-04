package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {
	@Id
	@Column(name = "r_id")
	@SequenceGenerator(sequenceName="role_id_maker", name="r_seq")
    @GeneratedValue(generator="r_seq", strategy=GenerationType.SEQUENCE)
	private int role_id;
	private String role_name;
	
	public Role() {
		super();
	}
	
	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	
	public int getR_id() {
		return role_id;
	}
	
	public void setR_id(int r_id) {
		this.role_id = r_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [r_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
}
