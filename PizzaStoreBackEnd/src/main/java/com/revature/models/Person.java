package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@SequenceGenerator(sequenceName = "person_id_maker", name = "p_seq",allocationSize=1)
	@GeneratedValue(generator = "p_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "person_id")
	private int personId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToMany
	@JoinTable(name = "person_pizza", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> favorites;

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, String username, String password, Location location, Role role,
			List<Pizza> favorites) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.location = location;
		this.role = role;
		this.favorites = favorites;
	}

	public Person(int personId, String firstName, String lastName, String username, String password, Location location,
			Role role, List<Pizza> favorites) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.location = location;
		this.role = role;
		this.favorites = favorites;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Pizza> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Pizza> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", location=" + location + ", role=" + role + ", favorites="
				+ favorites + "]";
	}

}
