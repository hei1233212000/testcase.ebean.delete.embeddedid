package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable public class UserRolePK implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long roleId;

	@Override public int hashCode() {
		return userId == null || roleId == null ? 0 : (int) (userId + roleId);
	}

	@Override public boolean equals(Object other) {
		if (userId == null || roleId == null) return false;
		if (other instanceof UserRolePK) {
			UserRolePK otherPk = (UserRolePK) other;
			return userId.equals(otherPk.userId) && roleId.equals(otherPk.roleId);
		}
		return false;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
