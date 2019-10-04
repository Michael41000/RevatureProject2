package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity													
public class Person {
	@Id
	@SequenceGenerator(sequenceName="person_id_maker", name="p_seq")
	@GeneratedValue(generator="p_seq", strategy=GenerationType.SEQUENCE)
	@Column(name = "p_id")
	private int person_id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	
	@ManyToOne
	private Location location;
	
	@OneToOne
	private Role role;
	
	public Person() {
		super();
	}

	public Person(int person_id, String first_name, String last_name, String username, String password,
			Location location, Role role) {
		super();
		this.person_id = person_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.location = location;
		this.role = role;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", username=" + username + ", password=" + password + ", location=" + location + ", role=" + role
				+ "]";
	}

}
