package com.example.auctionhouse.payment;

import java.util.List;

interface CardPaymentServiceImp{
    public void addCardPayment(CardPayment cp);
    public void getCardPayment();
    public void removeCardPayment(CardPayment cp);
}

public class CardPaymentService implements CardPaymentServiceImp{

    private static CardPaymentRepository cpr = new CardPaymentRepository("CardPayment.ser");


    @Override
    public void addCardPayment(CardPayment cp) {
        cpr.createCardPaymentDB(cp);
    }

    @Override
    public void getCardPayment() {
        for (CardPayment cardPayment : cpr.readCardPaymentListDB()) {
            if (cardPayment instanceof CreditCard){
                System.out.println("Credit Card");
            }
            else{
                System.out.println("Debit Card");
            }
            System.out.println("identity code: " + cardPayment.getIdentityCode());
            System.out.println("cvv: " + cardPayment.getCvv());
            System.out.println("expired on: " + cardPayment.getExpiryDate());
        }
    }

    @Override
    public void removeCardPayment(CardPayment cp) {
        cpr.deleteCardPaymentDB(cp);
    }
}
