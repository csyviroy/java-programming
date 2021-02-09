package com.example.auctionhouse.payment;

interface EAccountPaymentServiceImp{
    public void addEAccountPayment(EAccountPayment eap);
    public void getEAccountPayment();
    public void editEAccountPayment(EAccountPayment eap);
    public void removeEAccountPayment(EAccountPayment eap);
}

public class EAccountPaymentService implements EAccountPaymentServiceImp{

    private static EAccountPaymentRepository eapr = new EAccountPaymentRepository("Eaccount.ser");

    @Override
    public void addEAccountPayment(EAccountPayment eap) {
        eapr.createEAccountPaymentDB(eap);
    }

    @Override
    public void getEAccountPayment() {
        for (EAccountPayment eAccountPayment : eapr.readEAccountPaymentDBList()) {
            if (eAccountPayment instanceof GooglePay){
                System.out.println("Google Pay");
            }
            else if (eAccountPayment instanceof GrabPay){
                System.out.println("Grab Pay");
            }
            else{
                System.out.println("Samsung Pay");
            }

            System.out.println("username: " + eAccountPayment.getUsername());
            System.out.println("secret: " + eAccountPayment.getSecretKey());
            System.out.println("associated on: " + eAccountPayment.getAssociatedOn());
        }
    }

    @Override
    public void editEAccountPayment(EAccountPayment eap) {
        eapr.updateEAccountPaymentDB(eap);
    }

    @Override
    public void removeEAccountPayment(EAccountPayment eap) {
        eapr.deleteEAccountPaymentDB(eap);
    }
}
