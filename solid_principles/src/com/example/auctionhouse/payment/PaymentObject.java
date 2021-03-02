package com.example.auctionhouse.payment;

public class PaymentObject{
    private boolean verified = false;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}