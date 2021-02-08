package com.example.auctionhouse.payment;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class CardPayment implements PaymentInterface, Serializable{
	enum CardType{
		credit,
		debit
	}
	private String identityCode;
	private String cvvValue;
	private Date expiryDate;
	private CardType cardType;
	private boolean verified;
	
	CardPayment(String identityCode, String cvvValue, Date expiryDate, CardType cardType){
		this.identityCode = identityCode;
		this.cvvValue = cvvValue;
		this.expiryDate = expiryDate;
		this.cardType = cardType;
		this.verified = false;
		verify();
	}
	
	public String getIdentityCode() {
		return this.identityCode;
	}
	
	public String getcvvValue() {
		return this.cvvValue;
	}
	
	public Date getExpiryDate() {
		return this.expiryDate;
	}
	
	public CardType getCardType() {
		return this.cardType;
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
			System.out.printf("CardPayment of type %s for %.2f is successful", this.getCardType(), amount);
		}
		else {
			System.out.println("Card is not verified, payment failed");
		}
	}

	@Override
	public void verify() {
		// TODO Auto-generated method stub
		BankAPIService api = new BankAPIService();
		boolean result = api.verifyCard(this);
		if (result) {
			setVerified();
		}
	}

	@Override
	public String getIdentitifer() {
		// TODO Auto-generated method stub
		return this.getIdentityCode();
	}

}
