package com.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "user_role") public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserRolePK pk;

	private User user;
	private Role role;

	@EmbeddedId public UserRolePK getPk() {
		return pk;
	}

	public void setPk(UserRolePK pk) {
		this.pk = pk;
	}

	@ManyToOne @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false) public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne @JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false) public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
