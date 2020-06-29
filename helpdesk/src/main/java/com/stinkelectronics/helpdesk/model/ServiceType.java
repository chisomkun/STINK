package com.stinkelectronics.helpdesk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class ServiceType {
	
	@Id
	private long ServiceID;
	
	@Column(name="ServiceType")
	private String serviceDesc;
	
	public ServiceType() {
		ServiceID = 1;
		serviceDesc = "Flash drive restore";
	}
}
