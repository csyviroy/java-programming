package com.example.auctionhouse.payment;

public class GrabAPIService implements PaymentServiceImp{

    private GrabPay gp;

    public GrabAPIService(GrabPay gp) {
        this.gp = gp;
        if (verify()){
            System.out.println("Grab Pay interface verification successful.");
            this.gp.setVerified(true);
        }
        else{
            System.out.println("Grab Pay interface verification unsuccessful.");
            this.gp.setVerified(false);
        }
    }

    @Override
    public boolean verify() {
        System.out.println("Grab Worker is processing the detail.");
        System.out.println("Grab username: " + this.gp.getUsername());
        System.out.println("Grab secret code: " + this.gp.getSecretKey());
        System.out.println("Verification complete.");
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
            System.out.println("Grab Pay interface is not verified.");
        }
    }
}
