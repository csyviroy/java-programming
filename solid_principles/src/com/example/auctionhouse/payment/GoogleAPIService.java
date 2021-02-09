package com.example.auctionhouse.payment;

interface GoogleAPIServiceImp{
    public boolean verify(GooglePay gp);
    public void makeTransaction(double amt);
}

public class GoogleAPIService implements GoogleAPIServiceImp{

    @Override
    public boolean verify(GooglePay gp) {
        System.out.println("Verifying Google account detail: ");
        System.out.println("Google username: " + gp.getUsername());
        System.out.println("Secret value: " +  gp.getSecretKey());
        System.out.println("Account verification completed.");
        return true;
    }

    @Override
    public void makeTransaction(double amt) {
        System.out.println("Transaction completed.");
    }
}
