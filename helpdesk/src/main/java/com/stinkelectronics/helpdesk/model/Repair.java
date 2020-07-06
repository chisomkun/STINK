package com.stinkelectronics.helpdesk.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

//@SecondaryTable(name="Profile", pkJoinColumns=@PrimaryKeyJoinColumn(name="UserID"))
@Entity
@Table(name="RepairStatus")
public class Repair implements Serializable{
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long generatedID;*/
	
	@Id
	@Column(name="RepairID")
	private long repairID;
	
	@Column(name="EName")
	private String Desc;
	
	//@Column(name="Status")
	private String Status;
	
	//@Column(name="ServiceID")
	private long ServiceID;
	
	@OneToOne
	@JoinColumn(name="UserID", referencedColumnName="UserID")
	private Profile profile;
	
	//@OneToOne
	//@PrimaryKeyJoinColumn(name="UserID", referencedColumnName="UserID")
	//@Column(name="UserID")
	private long UserID;

	public Repair(long RepairID, String Desc, String Status, long ServiceID, long UserID) {
		this.repairID = RepairID;
		this.Desc = Desc;
		this.Status = Status;
		this.ServiceID = ServiceID;
		this.UserID = UserID;
	}
	
	public Repair(long UserID) {
		ServiceID = 1;
		this.UserID = UserID;
	}
	
	//getters
	public long getRepairID() {
		return repairID;
	}
	
	public String getDesc() {
		return Desc;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public long getServiceID() {
		return ServiceID;
	}
	
	public long getUserID() {
		return profile.getUserID();
	}
	
	//setters
	public void setRepairID(long RepairID) {
		this.repairID = RepairID;
	}
	
	public void setDesc(String Desc) {
		this.Desc = Desc;
	}
	
	public void setStatus(String Status){
		this.Status = Status;
	}
	
	public void setServiceID(long ServiceID) {
		this.ServiceID = ServiceID;
	}
	
	public void setUserID(long UserID) {
		this.UserID = UserID;
		this.profile.setUserID(UserID);
	}
	
}
