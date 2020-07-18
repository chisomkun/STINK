package com.stinkelectronics.helpdesk.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class Service {
	
	/* service types with their corresponding IDs
	 * 0- unserviced
	 * 1- cleaning
	 * 2- parts repair
	 * 3- parts replace
	 * 4- build
	 * 5- software issue
	 */
	
	@Id
	@OneToOne(mappedBy="service", cascade = CascadeType.ALL)
	private int ServiceID;
	
	private String ServiceType;
	
	public Service() {
		this.ServiceID = 0;
		this.ServiceType = "N/A";
	}
	
	public Service(int sid) {
		updateService(sid);
	}
	
	public void updateService(int sid) {
		this.ServiceID = sid;
		switch(sid) {
		case 0:
			this.ServiceType="N/A";
			break;
		case 1:
			this.ServiceType="Cleaning";
			break;
		case 2:
			this.ServiceType="Repair Part";
			break;
		case 3:
			this.ServiceType="Replace Part";
			break;
		case 4:
			this.ServiceType="Build";
			break;
		case 5:
			this.ServiceType="Fix Software";
			break;
		default:
			this.ServiceID = 0;
			this.ServiceType="N/A";
		}
	}
	
}
