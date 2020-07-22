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

	public Service(Integer ServiceID, String ServiceType) {
		this.ServiceID = 0;
		this.ServiceType = "N/A";
	}

	public Integer getServiceID() {
		return ServiceID;
	}

	public void setServiceID(Integer serviceID) {
		ServiceID = serviceID;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
}
