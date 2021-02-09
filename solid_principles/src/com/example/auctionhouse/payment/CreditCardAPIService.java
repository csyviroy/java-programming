package com.example.auctionhouse.payment;

import java.util.Date;

interface CreditCardAPIServiceImp{
    public boolean verify(CreditCard cc);
    public void makeTransaction(CreditCard cc, double amt);
}

public class CreditCardAPIService implements CreditCardAPIServiceImp{

    @Override
    public boolean verify(CreditCard cc) {
        System.out.println("Checking credit card: " + cc.getIdentityCode());
        System.out.println("cvv value: " + cc.getCvv());
        System.out.println("Expiry date: " + cc.getExpiryDate());
        Date current = new Date();
        if (!current.before(cc.getExpiryDate())){
            System.out.println("Card verification failed due to expiry date");
            return false;
        }
        else{
            System.out.println("Card verification complete.");
            return true;
        }
    }

    @Override
    public void makeTransaction(CreditCard cc, double amt) {
        System.out.println("Transaction complete.");
    }
}
