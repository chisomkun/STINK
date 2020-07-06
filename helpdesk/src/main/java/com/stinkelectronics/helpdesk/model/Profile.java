package com.stinkelectronics.helpdesk.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;;

@Entity
@Table(name="Profile")
/*@SecondaryTable(name="Account")
@SecondaryTables({
	@SecondaryTable(name="Account", pkJoinColumns=@PrimaryKeyJoinColumn(name="UserAID")),
	@SecondaryTable(name="RepairStatus", pkJoinColumns=@PrimaryKeyJoinColumn(name="RepairID"))
})*/
public class Profile implements Serializable {
	
	//@Id
	@Transient
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long generatedID;
	
	@Id
	@Column(name="UserID")
	private long userID;
	
	@OneToOne
	@JoinColumn(name="role_RoleID", referencedColumnName="RoleID")
	private Role role;
	
	@Transient
	private Account account;
	
	@Column(name="Username")
	private String username;
	
	@OneToOne
	//@Transient
	private Repair repair;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	public Profile(String FirstName, String Password, String Email) {
		account = new Account(UUID.randomUUID(), Password, Email);
		
		this.FirstName = FirstName;
		
		repair = new Repair(this.userID);
		//RepairID = Repair.getRepairID();
	}
	
	public Profile() {
		account = new Account();
		
		repair = new Repair(userID);
		//RepairID = Repair.getRepairID();
	}
	
	//getters
	
	public long getUserID() {
		return userID;
	}
	
	public long getRoleID() {
		return role.getRoleID();
	}
	
	public long getRepairID(){
		return repair.getRepairID();
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getPassword() {
		return account.getPassword();
	}
	
	public UUID GetUserAID() {
		return account.getUserAID();
	}
	
	public String getEmail() {
		return account.getEmail();
	}
	
	//Setters	
	public void setUserID(long UserID) {
		this.userID = UserID;
	}
	
	public void setRoleID(long RoleID) {
		role.setRoleID(RoleID);
	}
	
	public void setRepairID(long RepairID) {
		repair.setRepairID(RepairID);
		//this.RepairID = Repair.getRepairID();
	}
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public void setUserAID(UUID UserAID) {
		account.setUserAID(UserAID);
	}
	
	public void setPassword(String Password) {
		account.setPassword(Password);
	}
	
	public void setEmail(String Email) {
		account.setEmail(Email);
	}
}
