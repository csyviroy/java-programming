package com.example.auctionhouse.payment;

import java.util.Date;

public class DebitCard extends CardPayment{

    public DebitCard(String identityCode, short cvv, Date expiryDate) {
        super(identityCode, cvv, expiryDate);
    }

}
