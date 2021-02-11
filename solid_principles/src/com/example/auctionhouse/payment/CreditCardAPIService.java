package com.example.auctionhouse.payment;

import java.util.Date;

public class CreditCardAPIService implements PaymentServiceImp{

    private CreditCard cc;

    public CreditCardAPIService(CreditCard cc) {
        this.cc = cc;
    }

    @Override
    public boolean verify() {
        System.out.println("Checking credit card: " + this.cc.getIdentityCode());
        System.out.println("cvv value: " + this.cc.getCvv());
        System.out.println("Expiry date: " + this.cc.getExpiryDate());
        Date current = new Date();
        if (!current.before(this.cc.getExpiryDate())){
            System.out.println("Card verification failed due to expiry date");
            return false;
        }
        else{
            System.out.println("Card verification complete.");
            return true;
        }
    }

    @Override
    public void pay(double amt) {
        try{
            //deduct amt from cc
            System.out.println("Transaction Completed.");
        }
        catch (Exception e){
            System.out.println("Transaction Failed.");
        }
    }
}
