package com.example.auctionhouse.Convertor;

import com.example.auctionhouse.payment.PaymentServiceImp;

interface convertorImpl{
    public int convertMoneytoToken(PaymentServiceImp psi, double amount);
}

public class AuctionConversionService implements convertorImpl{

    @Override
    public int convertMoneytoToken(PaymentServiceImp psi, double amount) {
        psi.pay(amount);
        System.out.println("Amount: " + amount + " is deduced from the payment service.");
        return 1000;
    }
}
