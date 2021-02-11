package com.example.auctionhouse.userprofile;

import com.example.auctionhouse.payment.CardPayment;
import com.example.auctionhouse.payment.EAccountPayment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserProfile implements Serializable{
	private String name;
	private Date dob;
	private String occupation;
	private String uniqueID;
	private String createdAt;
	private List<CardPayment> cardPaymentList;
	private List<EAccountPayment> eAccountPaymentList;

	public UserProfile(String name, Date dob, String occupation){
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.uniqueID = UUID.randomUUID().toString();
		this.createdAt = new Date().toString();
		this.cardPaymentList = new ArrayList<>();
		this.eAccountPaymentList = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getUniqueID() {
		return this.uniqueID;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<CardPayment> getCardPaymentList() {
		return this.cardPaymentList;
	}

	public void setCardPaymentList(List<CardPayment> cardPaymentList) {
		this.cardPaymentList = cardPaymentList;
	}

	public List<EAccountPayment> getEAccountPaymentList() {
		return this.eAccountPaymentList;
	}

	public void setEAccountPaymentList(List<EAccountPayment> eAccountPaymentList) {
		this.eAccountPaymentList = eAccountPaymentList;
	}
}
