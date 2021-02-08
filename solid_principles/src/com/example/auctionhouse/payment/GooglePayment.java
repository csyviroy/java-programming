package com.example.auctionhouse.payment;

import java.io.Serializable;
import java.util.UUID;

public class GooglePayment implements PaymentInterface, Serializable {

	private String googleAccountName;
	private String googleAccountCurrency;
	private double googleAccountLimit;
	private String googleSecretValue;
	private boolean verified;
	
	GooglePayment(String googleAccountName, String googleSecretValue){
		this.googleAccountName = googleAccountName;
		this.googleSecretValue = googleSecretValue;
		this.verified = false;
		verify();
	}
	
	public String getGoogleAccountName() {
		return this.googleAccountName;
	}
	
	public String getGoogleAccountCurrency() {
		return this.googleAccountCurrency;
	}
	
	public void setGoogleAccountCurrency(String currency) {
		this.googleAccountCurrency = currency;
	}
	
	public double getGoogleAccountLimit() {
		return this.googleAccountLimit;
	}
	
	public void setGoogleAccountLimit(double limit) {
		this.googleAccountLimit = limit;
	}
	
	public String getGoogleSecretValue() {
		return this.googleSecretValue;
	}
	
	public void setVerified() {
		this.verified = true;
	}
	
	public boolean getVerified() {
		return this.verified;
	}
	
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		if (this.getVerified() == true) {
			System.out.printf("GooglePayment on google account: %s for %.2f is successful", this.getGoogleAccountName(), amount);
		}
		else {
			System.out.println("GooglePayment is not verified, payment failed");
		}
	}

	@Override
	public void verify() {
		// TODO Auto-generated method stub
		GoogleAccountAPIService api = new GoogleAccountAPIService();
		boolean result = api.verifyGoogleAccount(this);
		if (result) {
			setVerified();
		}
	}

	@Override
	public String getIdentitifer() {
		// TODO Auto-generated method stub
		return this.getGoogleSecretValue();
	}

}
