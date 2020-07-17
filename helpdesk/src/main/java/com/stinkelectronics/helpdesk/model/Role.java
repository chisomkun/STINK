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
	
	public Role() {
		this.RoleID = 1;
		this.Job = "Customer";
	}
	
}
