package com.example.auctionhouse.payment;

public class GooglePay extends EAccountPayment{

    private static GoogleAPIService googleAPI = new GoogleAPIService();

    public GooglePay(String username, String secretKey) {
        super(username, secretKey);
    }

    @Override
    public void pay(double amt) {
        if (googleAPI.verify(this)){
            googleAPI.makeTransaction(amt);
        }
    }
}
