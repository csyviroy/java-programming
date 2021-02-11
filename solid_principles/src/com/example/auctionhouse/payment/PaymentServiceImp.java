package com.example.auctionhouse.payment;

public interface PaymentServiceImp{
    boolean verify();
    void pay(double amt);
}