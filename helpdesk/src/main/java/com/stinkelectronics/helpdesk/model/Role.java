package com.stinkelectronics.helpdesk.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@OneToOne(mappedBy="role", cascade = CascadeType.ALL)
	private int RoleID;
	
	private String Job;
	
	public Role(int roleid) {
		updateJob(roleid);
	}
	
	public void updateJob(int roleid) {
		this.RoleID = roleid;
		switch(roleid) {
		case 1:
			this.Job = "customer";
			break;
		case 2:
			this.Job = "technician";
		case 3:
			this.Job = "administrator";
		default:
			this.Job = "customer";
			this.RoleID = 1;
		}
	}
	
	public int getRoleID() {
		return RoleID;
	}
	
	public void setRoleID(int roleid) {
		updateJob(roleid);
	}
	
	public String getJob() {
		return Job;
	}
	
}
