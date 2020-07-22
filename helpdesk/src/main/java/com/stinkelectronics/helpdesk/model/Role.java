package com.stinkelectronics.helpdesk.model;

public class Role {
	
	private Integer RoleID;
	private String Job;
	
	public Role() {
		this.RoleID = 0;
		this.Job = "N/A";
	}
	
	//TODO:
		//constructor with all parameters


	public Integer getRoleID() {
		return RoleID;
	}

	public void setRoleID(Integer roleID) {
		RoleID = roleID;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}
}
