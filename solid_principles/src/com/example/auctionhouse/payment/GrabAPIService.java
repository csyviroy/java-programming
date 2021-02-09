package com.example.auctionhouse.payment;

interface GrabAPIServiceImp{
    public boolean verify(GrabPay gp);
    public void makeTransaction(GrabPay gp, double amt);
}

public class GrabAPIService implements GrabAPIServiceImp{

    @Override
    public boolean verify(GrabPay gp) {
        System.out.println("Grab Worker is processing the detail.");
        System.out.println("Grab username: " + gp.getUsername());
        System.out.println("Grab secret code: " + gp.getSecretKey());
        System.out.println("Verification complete.");
        return true;
    }

    @Override
    public void makeTransaction(GrabPay gp, double amt) {
        System.out.println("Transaction complete.");
    }
}
