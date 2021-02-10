package com.example.auctionhouse.payment;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class PaymentConsole {
    public static void main(String[] args) {

        CardPaymentService cps = new CardPaymentService();
        EAccountPaymentService eaps = new EAccountPaymentService();

        cps.getCardPayment();

        System.out.println();
        eaps.getEAccountPayment();

    }

    void initializeData(CardPaymentService cps, EAccountPaymentService eaps){
        Calendar c = Calendar.getInstance();

        c.set(1994, Calendar.APRIL, 20);
        CardPayment cp = new DebitCard("92929183301", (short) 20, new Date());
        cp.pay(500);

        c.set(2021, Calendar.APRIL, 20);
        CreditCard cp1 = new CreditCard("1231231231231321", (short) 129, c.getTime());
        cp1.pay(500);

        cps.addCardPayment(cp);
        cps.addCardPayment(cp1);

        EAccountPayment eap = new GooglePay("john" , "123a2dvvc3cdssa12");
        GooglePay gp = new GooglePay("jack", "1231asd1ascac");

        GrabPay grabp = new GrabPay("tim", "1msnvbo5ls-aokdkssl");

        SamsungPay samp = new SamsungPay("jawn", "mdvi5-42343j2omsfasd");


        eaps.addEAccountPayment(eap);
        eaps.addEAccountPayment(gp);
        eaps.addEAccountPayment(grabp);
        eaps.addEAccountPayment(samp);
    }
}
