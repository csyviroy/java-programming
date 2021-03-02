package com.example.auctionhouse.ioservice;

import com.example.auctionhouse.Convertor.AuctionConversionService;
import com.example.auctionhouse.payment.*;
import com.example.auctionhouse.userprofile.UserProfile;
import com.example.auctionhouse.userprofile.UserProfileRepository;
import com.example.auctionhouse.userprofile.UserProfileService;

import java.util.*;

public class Index {
    public static <cls> void main(String[] args) {
        UserProfileRepository upr = new UserProfileRepository("userProfile.ser");
        boolean flag = false;
        if (flag) {
            initializeUserProfileBaseData(upr);
        }

        UserProfile u = null;

        String targetUserID = "1920d1f5-4cfe-4087-b945-224fb3737aa6";

        Iterator i = upr.getUserProfile().iterator();
        while (i.hasNext()){
            u = (UserProfile) i.next();
            System.out.println(u.getUniqueID());
            System.out.println("current token at: " + u.getUserProfileToken());
            if (u.getUniqueID().equals(targetUserID)){
                break;
            }
        }

        int z = 0;
        try {
            Class<? extends PaymentObject> cls = (Class<? extends PaymentObject>) Class.forName("com.example.auctionhouse.payment.GooglePay");
            //at this point, user decide to pay using GooglePay
            i = u.geteAccountPaymentList().iterator();
            while (i.hasNext()){
                PaymentObject po = (PaymentObject) i.next();
                if (cls.isInstance(po)){
                    break;
                }
                z++;
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        PaymentServiceFactory psf = new PaymentServiceFactory(u.geteAccountPaymentList().get(z));
        AuctionConversionService acs = new AuctionConversionService();
        int token = acs.convertMoneytoToken(psf.getAPIService(), 200);

        UserProfileService ups = new UserProfileService(u);
        ups.addToken(token);

        System.out.println("user from user profile class: " + u.getUserProfileToken());

        upr.updateUserProfile(u);

        i = upr.getUserProfile().iterator();
        while (i.hasNext()){
            u = (UserProfile) i.next();
            System.out.println(u.getUniqueID());
            System.out.println("current token at: " + u.getUserProfileToken());
            System.out.println("user: " + u.geteAccountPaymentList());
            System.out.println("user: " + u.getCardPaymentList());
        }

        System.out.println("index terminal end.");
    }

    static void initializeUserProfileBaseData(UserProfileRepository upr){
        UserProfile up = new UserProfile("Viroy", new Date(2020, Calendar.FEBRUARY, 05), "Student");
        CardPayment cp = new DebitCard("51029384069492", (short) 202, new Date(2020, Calendar.NOVEMBER, 20));
        CardPayment cp1 = new CreditCard("1034496922101", (short) 111, new Date(2020, Calendar.APRIL, 20));
        EAccountPayment eap = new GooglePay("viroy", "password12345");
        SamsungPay sp = new SamsungPay("viroy1", "password12345");

        UserProfileService ups = new UserProfileService(up);
        up = ups.addCardPayment(cp);
        up = ups.addCardPayment(cp1);
        up = ups.addEAccountPayment(eap);
        upr.addUserProfile(up);

        up = ups.addEAccountPayment(sp);
        upr.updateUserProfile(up);

    }
}
