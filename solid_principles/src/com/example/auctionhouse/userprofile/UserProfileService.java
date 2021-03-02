package com.example.auctionhouse.userprofile;

import com.example.auctionhouse.payment.CardPayment;
import com.example.auctionhouse.payment.EAccountPayment;

import java.util.List;

/**
 * UserProfileService class provide service to add or delete CardPayment, add or delete EAccountPayment
 * and add or subtract userprofile token amount
 */

interface UserProfileTokenImp{
    public void addToken(int amount);
    public void subtractToken(int amount);
}

interface UserProfileServiceImp{
    public UserProfile addEAccountPayment(EAccountPayment eap);
    public UserProfile deleteEAccountPayment(EAccountPayment eap);
    public UserProfile addCardPayment(CardPayment cp);
    public UserProfile deleteCardPayment(CardPayment cp);
}

public class UserProfileService implements UserProfileServiceImp, UserProfileTokenImp{
    private UserProfile up;

    public UserProfileService(UserProfile up) {
        this.up = up;
    }

    @Override
    public UserProfile addEAccountPayment(EAccountPayment eap) {
        List<EAccountPayment> ls = this.up.geteAccountPaymentList();
        ls.add(eap);
        this.up.seteAccountPaymentList(ls);
        return this.up;
    }

    @Override
    public UserProfile deleteEAccountPayment(EAccountPayment eap) {
        List<EAccountPayment> ls = this.up.geteAccountPaymentList();
        ls.remove(eap);
        this.up.seteAccountPaymentList(ls);
        return this.up;
    }

    @Override
    public UserProfile addCardPayment(CardPayment cp) {
        List<CardPayment> ls = this.up.getCardPaymentList();
        ls.add(cp);
        this.up.setCardPaymentList(ls);
        return this.up;
    }

    @Override
    public UserProfile deleteCardPayment(CardPayment cp) {
        List<CardPayment> ls = this.up.getCardPaymentList();
        ls.remove(cp);
        this.up.setCardPaymentList(ls);
        return this.up;
    }

    @Override
    public void addToken(int amount) {
        this.up.setUserProfileToken(this.up.getUserProfileToken() + amount);
    }

    @Override
    public void subtractToken(int amount) {
        if (this.up.getUserProfileToken() > amount) {
            this.up.setUserProfileToken(this.up.getUserProfileToken() - amount);
        }
        else{
            System.out.println("Invalid amount of token to subtract.");
        }
    }
}
