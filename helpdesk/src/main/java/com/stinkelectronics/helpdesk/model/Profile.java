package com.stinkelectronics.helpdesk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;;

@Entity
@Table(name="Profile")
public class Profile implements Serializable {
	
	@Id
	@OneToOne(mappedBy="profile", cascade = CascadeType.ALL)
	private String UserID;
	
	private String FirstName;
	private String LastName;
	
	//map foreign keys
	@OneToOne
	@JoinColumn(name="FK_RoleID")
	private Role role;
	
	//Unidirectional, best parctice is to make bidirectional but that requires alteration of sql tables.
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="FK_RepairID")
	private List<Repair> repair;
	
	public Profile() {
		this.UserID = "defaultuserid";
		
		this.FirstName = "defaultfirstname";
		this.LastName = "defaultlastname";
		
		this.role = new Role();
		this.repair = new ArrayList<Repair>();
	}
	
}
