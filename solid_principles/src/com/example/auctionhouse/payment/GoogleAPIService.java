package com.example.auctionhouse.payment;

public class GoogleAPIService implements PaymentServiceImp{

    GooglePay gp;

    public GoogleAPIService(GooglePay gp) {
        this.gp = gp;
        if (verify()){
            System.out.println("Google Pay interface verification successful.");
            this.gp.setVerified(true);
        }
        else{
            System.out.println("Google Pay interface verification unsuccessful.");
            this.gp.setVerified(false);
        }
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
        if (this.gp.isVerified()) {
            try {
                System.out.println("Transaction Completed.");
            } catch (Exception e) {
                System.out.println("Transaction Failed.");
            }
        }
        else{
            System.out.println("Google Pay interface is not verified.");
        }
    }


}
