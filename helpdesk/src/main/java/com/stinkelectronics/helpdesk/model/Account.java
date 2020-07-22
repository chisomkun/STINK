package com.stinkelectronics.helpdesk.model;

import java.io.Serializable;
import java.util.List;

public class Account{
	
	private String Email;
	private String Password;
	
	private String UserID;
	
	public Account(){
		this.Password = "defaultpassword";
		this.Email = "defaultemail";
		
		this.UserID = "defaultuserid";
	}
	
	//TODO:
	//constructor with all parameters

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}
}

