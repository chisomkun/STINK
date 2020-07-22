package com.stinkelectronics.helpdesk.model;

public class Role {
	
	private Integer RoleID;
	private String Job;
	
	public Role() {
		this.RoleID = 0;
		this.Job = "N/A";
	}

	public Role(Integer RoleID, String Job) {
		this.RoleID = 0;
		this.Job = "N/A";
	}

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
