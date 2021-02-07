package com.example.auctionhouse.payment;

import java.io.Serializable;
import java.util.UUID;

abstract class PaymentType implements Serializable{
	protected String paymentID;
	
	public String getPaymentID() {
		return this.paymentID;
	}
	
	public void setPaymentID(String id) {
		this.paymentID = id;
	}
	
	public abstract void pay(double amount);
	public abstract void verify();
}
