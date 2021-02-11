package com.example.auctionhouse.payment;

import java.util.Date;

public class CreditCard extends CardPayment{

    public CreditCard(String identityCode, short cvv, Date expiryDate) {
        super(identityCode, cvv, expiryDate);
    }

}
