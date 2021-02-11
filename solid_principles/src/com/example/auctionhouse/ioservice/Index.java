package com.example.auctionhouse.ioservice;

import com.example.auctionhouse.payment.*;
import com.example.auctionhouse.userprofile.UserProfile;
import com.example.auctionhouse.userprofile.UserProfileRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Index {
    public static void main(String[] args) {
        UserProfileRepository upr = new UserProfileRepository("userProfile.ser");
        List<UserProfile> userList = upr.getUserProfile();
        userList.forEach((n)->{
            System.out.println("user (" + n.getName() + ") - occupation (" + n.getOccupation() + ")");
            List<CardPayment> nList = n.getCardPaymentList();
            Iterator i = nList.iterator();
            while (i.hasNext()){
                CardPayment cp = (CardPayment) i.next();
                System.out.println("card payment identity: " + cp.getIdentityCode() + " - expire on: " + cp.getExpiryDate());
            }
            List<EAccountPayment> eList = n.getEAccountPaymentList();
            i = eList.iterator();
            while (i.hasNext()) {
                EAccountPayment eap = (EAccountPayment) i.next();
                System.out.println("Eaccount username: " + eap.getUsername() + " - password: " + eap.getSecretKey());
            }
        });
        CardPayment cp = userList.get(0).getCardPaymentList().get(0);
        PaymentServiceImp psi = new PaymentServiceFactory(cp).getAPIService();
        if (psi.verify())
            psi.pay(200);
        System.out.println("index terminal end.");
    }

    static void initializeUserProfileBaseData(UserProfileRepository upr){
        UserProfile up = new UserProfile("Viroy", new Date(2020, Calendar.FEBRUARY, 05), "Student");
        CardPayment cp = new DebitCard("51029384069492", (short) 202, new Date(2020, Calendar.NOVEMBER, 20));
        CardPayment cp1 = new CreditCard("1034496922101", (short) 111, new Date(2020, Calendar.APRIL, 20));
        List<CardPayment> cardList = up.getCardPaymentList();
        cardList.add(cp);
        cardList.add(cp1);
        up.setCardPaymentList(cardList);

        EAccountPayment eap = new GooglePay("viroy", "password12345");
        SamsungPay sp = new SamsungPay("viroy1", "password12345");
        List<EAccountPayment> eaccList = up.getEAccountPaymentList();
        eaccList.add(eap);
        eaccList.add(sp);

        upr.addUserProfile(up);
    }
}
