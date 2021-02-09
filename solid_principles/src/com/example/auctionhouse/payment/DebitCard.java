package com.example.auctionhouse.payment;

import java.util.Date;

public class DebitCard extends CardPayment{

    private static DebitCardAPIService dcAPI = new DebitCardAPIService();

    public DebitCard(String identityCode, short cvv, Date expiryDate) {
        super(identityCode, cvv, expiryDate);
    }

    @Override
    public void pay(double amt) {
        boolean verified = dcAPI.verify(this);
        if (verified){
            dcAPI.makeTransaction(this, amt);
        }
    }
}
