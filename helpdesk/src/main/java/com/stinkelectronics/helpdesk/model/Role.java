package com.stinkelectronics.helpdesk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	
	@Column(name="RoleID")
	@Id
	private long roleID;
	
	@OneToOne(mappedBy="role")
	private Profile profile;

	@Column(name="Job")
	private String job;
	
	public Role() {
		this.roleID = 1;
		this.job = "customer";
	}
	
	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
