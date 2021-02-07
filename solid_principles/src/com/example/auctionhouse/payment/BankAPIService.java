package com.example.auctionhouse.payment;

interface BankVerification {
	public boolean verifyCard(CardPayment p);
}

public class BankAPIService implements BankVerification{

	@Override
	public boolean verifyCard(CardPayment p) {
		// TODO Auto-generated method stub
		//Check payment p, return true
		System.out.println("Checking card information: ");
		System.out.println("Card ID: " + p.getIdentityCode());
		System.out.println("CVV: " + p.getcvvValue());
		System.out.println("Expire on: " + p.getExpiryDate());
		System.out.println("Card verified...");
		return true;
	}
	
}
