package com.stinkelectronics.helpdesk.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="RepairStatus")
//@SecondaryTable(name="Profile", pkJoinColumns=@PrimaryKeyJoinColumn(name="UserID"))
public class Repair {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long generatedID;*/
	
	@Id
	@Column(name="RepairID")
	private UUID RepairID;
	
	@Column(name="EName")
	private String Desc;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="ServiceID")
	private String ServiceID;
	
	//@OneToOne
	//@PrimaryKeyJoinColumn(name="UserID", referencedColumnName="UserID")
	@Column(name="UserID")
	private String UserID;

	public Repair(UUID RepairID, String Desc, String Status, String ServiceID, String UserID) {
		this.RepairID = RepairID;
		this.Desc = Desc;
		this.Status = Status;
		this.ServiceID = ServiceID;
		this.UserID = UserID;
	}
	
	public Repair(String UserID) {
		RepairID = UUID.randomUUID();
		ServiceID = "S1";
		this.UserID = UserID;
	}
	
	//getters
	public UUID getRepairID() {
		return RepairID;
	}
	
	public String getDesc() {
		return Desc;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public String getServiceID() {
		return ServiceID;
	}
	
	public String getUserID() {
		return UserID;
	}
	
	//setters
	public void setRepairID(UUID RepairID) {
		this.RepairID = RepairID;
	}
	
	public void setDesc(String Desc) {
		this.Desc = Desc;
	}
	
	public void setStatus(String Status){
		this.Status = Status;
	}
	
	public void setServiceID(String ServiceID) {
		this.ServiceID = ServiceID;
	}
	
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	
}
