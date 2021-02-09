package com.example.auctionhouse.payment;

import java.util.Date;

interface DebitCardAPIServiceImp{
    public boolean verify(DebitCard dc);
    public void makeTransaction(DebitCard dc, double amt);
}

public class DebitCardAPIService implements DebitCardAPIServiceImp{

    @Override
    public boolean verify(DebitCard dc) {
        System.out.println("Checking debit card: " + dc.getIdentityCode());
        System.out.println("cvv value: " + dc.getCvv());
        System.out.println("Expiry date: " + dc.getExpiryDate());
        Date current = new Date();
        if (!current.before(dc.getExpiryDate())){
            System.out.println("Card verification failed due to expiry date");
            return false;
        }
        else{
            System.out.println("Card verification complete.");
            return true;
        }
    }

    @Override
    public void makeTransaction(DebitCard dc, double amt) {
        System.out.printf("Transaction complete.");
    }
}
