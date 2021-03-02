package com.example.auctionhouse.payment;

public class SamsungAPIService implements PaymentServiceImp{

    SamsungPay sp;

    public SamsungAPIService(SamsungPay sp) {
        this.sp = sp;
        if (verify()){
            System.out.println("Samsung Pay interface verification successful.");
            this.sp.setVerified(true);
        }
        else{
            System.out.println("Samsung Pay interface verification unsuccessful.");
            this.sp.setVerified(false);
        }
    }

    @Override
    public boolean verify() {
        System.out.println("Samsung is looking through the information provided.");
        System.out.println("username: " + this.sp.getUsername());
        System.out.println("secret: " + this.sp.getSecretKey());
        System.out.println("Verification complete.");
        return true;
    }

    @Override
    public void pay(double amt) {
        if (this.sp.isVerified()) {
            try {
                //deduct amt from sp
                System.out.println("Transaction Completed.");
            } catch (Exception e) {
                System.out.println("Transaction Failed.");
            }
        }
        else{
            System.out.println("Samsung Pay interface is not verified.");
        }
    }
}
