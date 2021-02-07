package com.example.auctionhouse.userprofile;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UserProfile implements Serializable{
	private String name;
	private Date dob;
	private String occupation;
	private String uniqueID;
	private String createdAt;
	
	UserProfile(String name, Date dob, String occupation){
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.uniqueID = UUID.randomUUID().toString();
		Date d = new Date();
		this.createdAt = d.toString();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getDob() {
		return this.dob;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getOccupation() {
		return this.occupation;
	}
	
	public String getUniqueID() {
		return this.uniqueID;
	}
	
	public String getCreatedAt() {
		return this.createdAt;
	}

}
