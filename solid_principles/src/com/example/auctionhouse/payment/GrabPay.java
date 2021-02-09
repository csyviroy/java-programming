package com.example.auctionhouse.payment;

public class GrabPay extends EAccountPayment{

    private static GrabAPIService grabAPI = new GrabAPIService();

    public GrabPay(String username, String secretKey) {
        super(username, secretKey);
    }

    @Override
    public void pay(double amt) {
        if (grabAPI.verify(this)){
            grabAPI.makeTransaction(this, amt);
        }
    }
}
