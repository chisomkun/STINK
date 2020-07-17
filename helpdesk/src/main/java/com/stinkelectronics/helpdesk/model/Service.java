package com.stinkelectronics.helpdesk.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class Service {
	
	@Id
	@OneToOne(mappedBy="service", cascade = CascadeType.ALL)
	private long ServiceID;
	
	private String ServiceType;
	
	public Service() {
		this.ServiceID = 0;
		this.ServiceType = "N/A";
	}
	
}
