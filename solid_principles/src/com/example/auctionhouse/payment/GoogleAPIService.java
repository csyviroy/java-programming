package com.example.auctionhouse.payment;

public class GoogleAPIService implements PaymentServiceImp{

    GooglePay gp;

    public GoogleAPIService(GooglePay gp) {
        this.gp = gp;
    }

    @Override
    public boolean verify() {
        System.out.println("Verifying Google account detail: ");
        System.out.println("Google username: " + this.gp.getUsername());
        System.out.println("Secret value: " +  this.gp.getSecretKey());
        System.out.println("Account verification completed.");
        return true;
    }

    @Override
    public void pay(double amt) {
        try{
            System.out.println("Transaction Completed.");
        }
        catch (Exception e){
            System.out.println("Transaction Failed.");
        }
    }


}
