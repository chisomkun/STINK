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
	//getters and setters
	
}

