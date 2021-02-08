package com.example.auctionhouse.payment;

import java.util.Calendar;
import java.util.Date;

import com.example.auctionhouse.payment.CardPayment.CardType;

public class PaymentInterfaceConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentInterfaceService pis = new PaymentInterfaceService();
//		pis.addPaymentInterface("john", "123123123");
//		pis.addPaymentInterface("TimMostMan", "321321321");
//		Date d = new Date(2022, Calendar.FEBRUARY, 05);
//		pis.addPaymentInterface("21212125151531", "351", d, CardType.credit);
//		pis.addPaymentInterface("12345678912345", "111", d, CardType.debit);
		
		pis.viewPaymentInterfaceList();
		
	}

}
