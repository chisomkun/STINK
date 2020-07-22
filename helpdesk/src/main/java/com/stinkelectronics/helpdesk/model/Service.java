package com.stinkelectronics.helpdesk.model;

public class Service {
	
	/* service types with their corresponding IDs
	 * 0- unserviced
	 * 1- cleaning
	 * 2- parts repair
	 * 3- parts replace
	 * 4- build
	 * 5- software issue
	 */
	private Integer ServiceID;
	private String ServiceType;
	
	public Service() {
		this.ServiceID = 0;
		this.ServiceType = "N/A";
	}
	
	//TODO:
		//constructor with all parameters
		//getters and setters
	
}
