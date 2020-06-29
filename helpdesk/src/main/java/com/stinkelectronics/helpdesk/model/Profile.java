package com.stinkelectronics.helpdesk.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Profile")
/*@SecondaryTable(name="Account")*/
@SecondaryTables({
	@SecondaryTable(name="Account", pkJoinColumns=@PrimaryKeyJoinColumn(name="UserAID")),
	@SecondaryTable(name="RepairStatus", pkJoinColumns=@PrimaryKeyJoinColumn(name="RepairID"))
})
public class Profile{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long generatedID;
	
	@Transient
	private Account account;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="RepairID", referencedColumnName="RepairID")
	private Repair repair;
	
	@Column(name="UserID")
	private String UserID;
	
	@Column(name="RoleID")
	private String RoleID;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	public Profile(String FirstName, String Password, String Email) {
		account = new Account(UUID.randomUUID(), Password, Email);
		
		this.FirstName = FirstName;
		
		RoleID = ROLEID.CUSTOMER.name();
		UserID = "defaultuser";
		
		repair = new Repair(this.UserID);
	}
	
	public Profile() {
		account = new Account();
		
		RoleID = ROLEID.CUSTOMER.name();
		UserID = "defaultuser";
		
		repair = new Repair(UserID);
	}
	
	//getters
	
	public String getUserID() {
		return UserID;
	}
	
	public String getRoleID() {
		return RoleID;
	}
	
	public UUID getRepairID(){
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
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	
	public void setRoleID(String RoleID) {
		this.RoleID = RoleID;
	}
	
	public void setRepairID(UUID RepairID) {
		repair.setRepairID(RepairID);
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
