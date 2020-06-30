package com.stinkelectronics.helpdesk.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//test
@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long generatedID;
	
	@Column(name="UserAID")
	private UUID UserAID;
	
	@Column(name="Password")
	private String Password;
	
	@Column(name="Email")
	private String Email;
	
	public Account() {
		UserAID = UUID.randomUUID();
		Password = "defaultpassword";
		Email = "defaultmail@email.com";
	}
	
	public Account(UUID UserAID, String Password, String Email) {
		this.UserAID = UserAID;
		this.Password = Password;
		this.Email = Email;
	}
	
	//getters
	public UUID getUserAID() {
		return UserAID;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getPassword() {
		return Password;
	}
	
	//setters
	public void setUserAID(UUID UserAID) {
		this.UserAID = UserAID;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
}

