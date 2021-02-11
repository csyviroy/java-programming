package com.example.auctionhouse.payment;

import java.io.*;
import java.util.Date;

public abstract class CardPayment extends PaymentObject implements Serializable{
    private String identityCode;
    private short cvv;
    private Date expiryDate;

    public CardPayment(String identityCode, short cvv, Date expiryDate) {
        this.identityCode = identityCode;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public short getCvv() {
        return cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}