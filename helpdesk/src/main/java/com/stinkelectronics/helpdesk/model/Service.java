package com.stinkelectronics.helpdesk.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class Service {
	
	@Id
	private long ServiceID;
	
	private String ServiceType;
	
	public Service() {
		this.ServiceType = "Flash Drive Recovery";
	}
	
	/*
	public Service(ServiceID) {
		this.ServiceID = ServiceID;
		this.ServiceType = "Flash Drive Recovery";
	}
	*/

	public long getServiceID() {
		return ServiceID;
	}

	public void setServiceID(long serviceID) {
		ServiceID = serviceID;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
}
