package com.stinkelectronics.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

public class Profile{

	private String UserID;
	private String FirstName;
	private String LastName;

	private int RoleID;
	private int RepairID;
	
	public Profile() {
		this.UserID = "defaultuserid";
		
		this.FirstName = "defaultfirstname";
		this.LastName = "defaultlastname";
		
		this.RoleID = 1;
		this.RepairID = 0;;
	}
	
	//TODO:
		//constructor with all parameters
		//getters and setters
	
}
