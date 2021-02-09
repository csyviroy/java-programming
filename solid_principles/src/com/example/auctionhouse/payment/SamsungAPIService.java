package com.example.auctionhouse.payment;

interface samsungAPIServiceInterface{
    public boolean verify(SamsungPay sp);
    public void makeTransaction(SamsungPay sp, double amt);
}
public class SamsungAPIService implements  samsungAPIServiceInterface{
    @Override
    public boolean verify(SamsungPay sp) {
        System.out.println("Samsung is looking through the information provided.");
        System.out.println("username: " + sp.getUsername());
        System.out.println("secret: " + sp.getSecretKey());
        System.out.println("Verification complete.");
        return true;
    }

    @Override
    public void makeTransaction(SamsungPay sp, double amt) {
        System.out.println("Transaction complete.");
    }
}
