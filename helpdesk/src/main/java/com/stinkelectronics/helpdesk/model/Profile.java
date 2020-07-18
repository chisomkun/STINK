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
	
	//Unidirectional, best practice is to make bidirectional but that requires alteration of sql tables.
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="FK_RepairID")
	private List<Repair> repairs;
	
	public Profile() {
		this.UserID = "defaultuserid";
		
		this.FirstName = "defaultfirstname";
		this.LastName = "defaultlastname";
		
		this.role = new Role(1);
		this.repairs = new ArrayList<Repair>();
	}
	
	public Profile(String fName) {
		this.UserID = "defaultuserid";
		this.FirstName = fName;
		
		this.role = new Role(1);
		this.repairs = new ArrayList<Repair>();
	}
	
	//fields
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	//role
	
	public Role getRole() {
		return role;
	}
	
	public int getRoleID() {
		return role.getRoleID();
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void updateRole(int rid) {
		this.role.updateJob(rid);
	}
	
	//manage repair
	public List<Repair> getRepairs() {
		return repairs;
	}
	
	public Repair getRepairById(int rid) {
		for(int i = 0; i < repairs.size(); i++) {
			if(repairs.get(i).getRepairID() == rid) {
				return repairs.get(i);
			}
		}
		//no repair could be found
		//need exception, return new repair for now.
		return new Repair();
	}
	
	public void addRepair(Repair rpair) {
		repairs.add(rpair);
	}
	
	public void removeRepair(int rid) {
		repairs.remove(repairs.indexOf(getRepairById(rid)));
	}
	
	public void updateRepair(int rid, String ename, String status) {
		int rindex = repairs.indexOf(getRepairById(rid));
		Repair rpair = repairs.get(rindex);
		
		rpair.setEName(ename);
		rpair.setStatus(status);
		
		repairs.set(rindex, rpair);
	}
	
	
}
