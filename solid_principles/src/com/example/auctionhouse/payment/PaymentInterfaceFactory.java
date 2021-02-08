package com.example.auctionhouse.payment;

import java.util.Date;

import com.example.auctionhouse.payment.CardPayment.CardType;

interface GooglePaymentInterface{
	public PaymentInterface createPaymentInterface(String googleAccountName, String googleSecretValue);
}

interface CardPaymentInterface{
	public PaymentInterface createPaymentInterface(String identityCode, String cvvValue, Date expiryDate, CardType type);
}

public class PaymentInterfaceFactory implements GooglePaymentInterface, CardPaymentInterface{

	@Override
	public PaymentInterface createPaymentInterface(String identityCode, String cvvValue, Date expiryDate,
			CardType type) {
		// TODO Auto-generated method stub
		PaymentInterface pi = new CardPayment(identityCode, cvvValue, expiryDate, type);
		return pi;
	}

	@Override
	public PaymentInterface createPaymentInterface(String googleAccountName, String googleSecretValue) {
		// TODO Auto-generated method stub
		PaymentInterface pi = new GooglePayment(googleAccountName, googleSecretValue);
		return pi;
	}

	
}
