package com.example.auctionhouse.payment;

interface PaymentInterface{
	public String getIdentitifer();
	public void pay(double amount);
	public void verify();
}
