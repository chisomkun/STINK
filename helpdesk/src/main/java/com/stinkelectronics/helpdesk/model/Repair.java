package com.stinkelectronics.helpdesk.model;

public class Repair{
	
	private String EName;
	private String Status;
	
	private int ServiceID;
	
	public Repair() {
		this.EName = "default repair";
		this.Status = "N/A";
		
		this.ServiceID = 0;
	}
	
	//TODO:
		//constructor with all parameters


	public String getEName() {
		return EName;
	}

	public void setEName(String EName) {
		this.EName = EName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getServiceID() {
		return ServiceID;
	}

	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}
}
