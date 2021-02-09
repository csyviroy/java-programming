package com.example.auctionhouse.payment;

import java.util.Date;

public class CreditCard extends CardPayment{

    private static CreditCardAPIService ccAPI = new CreditCardAPIService();

    public CreditCard(String identityCode, short cvv, Date expiryDate) {
        super(identityCode, cvv, expiryDate);
    }

    @Override
    public void pay(double amt) {
        boolean verified = ccAPI.verify(this);
        if (verified){
            ccAPI.makeTransaction(this, amt);
        }
    }
}
