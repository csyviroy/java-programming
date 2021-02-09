package com.example.auctionhouse.payment;

public class SamsungPay extends EAccountPayment{

    private static SamsungAPIService samsungAPI = new SamsungAPIService();

    public SamsungPay(String username, String secretKey) {
        super(username, secretKey);
    }

    @Override
    public void pay(double amt) {
        if (samsungAPI.verify(this)){
            samsungAPI.makeTransaction(this, amt);
        }
    }
}
