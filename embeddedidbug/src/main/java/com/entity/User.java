package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "user") public class User {
	private Long id;
	private String name;
	private Set<UserRole> userRoles;

	public User() {}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.REMOVE) public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override public String toString() {
		return String.format("id: %d, name: %s", id, name);
	}

}
