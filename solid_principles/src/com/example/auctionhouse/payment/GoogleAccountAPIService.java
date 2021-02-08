package com.example.auctionhouse.payment;


interface GoogleVerification{
	public boolean verifyGoogleAccount(GooglePayment g);
}

public class GoogleAccountAPIService implements GoogleVerification{

	@Override
	public boolean verifyGoogleAccount(GooglePayment g) {
		// TODO Auto-generated method stub
		System.out.println("Checking account information: ");
		System.out.println("Google account name: " + g.getGoogleAccountName());
		System.out.println("Google account secret value: " +  g.getGoogleSecretValue());
		g.setGoogleAccountCurrency("USD");
		System.out.println("Account verified...");
		return true;
	}
	
}
