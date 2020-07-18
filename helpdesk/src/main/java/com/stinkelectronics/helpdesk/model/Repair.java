package com.stinkelectronics.helpdesk.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RepairStatus")
public class Repair implements Serializable{
	
	//autogenerated sql side
	@Id
	private int RepairID;
	
	private String EName;
	private String Status;
	
	//map foreign key
	@OneToOne
	@JoinColumn(name="FK_ServiceID")
	private Service service;
	
	public Repair() {
		this.EName = "default repair";
		this.Status = "N/A";
		
		this.service = new Service();
	}
	
	public Repair(String ename, int stype) {
		this.EName = ename;
		this.Status = "0%";
		
		this.service = new Service(stype);
	}
	
	public int getRepairID() {
		return RepairID;
	}
	
	public String getEName() {
		return EName;
	}

	public void setEName(String eName) {
		EName = eName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}
