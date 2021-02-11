package com.example.auctionhouse.payment;

import java.util.Date;

public class DebitCardAPIService implements PaymentServiceImp{

    private DebitCard dc;

    public DebitCardAPIService(DebitCard dc) {
        this.dc = dc;
    }

    @Override
    public boolean verify() {
        System.out.println("Checking debit card: " + this.dc.getIdentityCode());
        System.out.println("cvv value: " + this.dc.getCvv());
        System.out.println("Expiry date: " + this.dc.getExpiryDate());
        Date current = new Date();
        if (!current.before(this.dc.getExpiryDate())){
            System.out.println("Card verification failed due to expiry date");
            return false;
        }
        else{
            System.out.println("Card verification complete.");
            return true;
        }
    }

    public void pay(double amt){
        try {
            //deduct amt from db
            System.out.println("Transaction Completed.");
        }
        catch (Exception e) {
            System.out.println("Transaction Failed.");
        }
    }
}
