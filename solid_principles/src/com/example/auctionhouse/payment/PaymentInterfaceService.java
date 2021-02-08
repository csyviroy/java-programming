package com.example.auctionhouse.payment;

import java.util.Date;
import java.util.List;

import com.example.auctionhouse.payment.CardPayment.CardType;

interface PaymentInterfaceServiceAction{
	public void addPaymentInterface(String identityCode, String cvvValue, Date expiryDate,
			CardType type);
	public void addPaymentInterface(String googleAccountName, String googleSecretValue);
	public void deletePaymentInterface(String identifier);
	public void viewPaymentInterfaceList();
	public void viewPaymentInterface(String identifier);
	public void chargePaymentInterface(String identifier, double amt);
}

public class PaymentInterfaceService implements PaymentInterfaceServiceAction{
	private PaymentInterfaceRepository pir = new PaymentInterfaceRepository("paymentInterface.ser");

	@Override
	public void addPaymentInterface(String identityCode, String cvvValue, Date expiryDate,
			CardType type) {
		// TODO Auto-generated method stub
		PaymentInterfaceFactory pif = new PaymentInterfaceFactory();
		PaymentInterface pi = pif.createPaymentInterface(identityCode, cvvValue, expiryDate, type);
		pir.addPaymentInterface(pi);
	}

	@Override
	public void addPaymentInterface(String googleAccountName, String googleSecretValue) {
		// TODO Auto-generated method stub
		PaymentInterfaceFactory pif = new PaymentInterfaceFactory();
		PaymentInterface pi = pif.createPaymentInterface(googleAccountName, googleSecretValue);
		pir.addPaymentInterface(pi);
	}
	
	@Override
	public void deletePaymentInterface(String identifier) {
		// TODO Auto-generated method stub
		PaymentInterface pi = pir.getPaymentInterface(identifier);
		if (pi != null) {
			pir.deletePaymentInterface(pi);
		}
		else {
			System.out.println("System failed to delete payment interface");
		}
	}

	@Override
	public void viewPaymentInterfaceList() {
		// TODO Auto-generated method stub
		List<PaymentInterface> piList = pir.getPaymentInterfaceList();
		piList.forEach((u) -> {
			if (u instanceof GooglePayment) {
				System.out.printf("Google Account Payment information - Name: %s ; Currency Setting: %s\n", u.getIdentitifer(), ((GooglePayment) u).getGoogleAccountCurrency());
			}
			else {
				System.out.printf("Card Payment information - identity code: %s ; Expired on: %s\n", u.getIdentitifer(), ((CardPayment)u).getExpiryDate());
			}
		});
	}

	@Override
	public void viewPaymentInterface(String identifier) {
		// TODO Auto-generated method stub
		PaymentInterface pi = pir.getPaymentInterface(identifier);
		if (pi != null) {
			if (pi instanceof GooglePayment) {
				System.out.printf("Google Account Payment information - Name: %s ; Currency Setting: %s (%s)\n", ((GooglePayment) pi).getGoogleAccountName(), ((GooglePayment) pi).getGoogleAccountCurrency(), ((GooglePayment) pi).getVerified());
			}
			else {
				System.out.printf("Card Payment information - Identity Code: %s ; Card Type: %s ; Expired on: %s", ((CardPayment) pi).getIdentityCode(), ((CardPayment) pi).getCardType(), ((CardPayment) pi).getExpiryDate());
			}
		}
		else
			System.out.println("No matching payment interface found");
	}

	@Override
	public void chargePaymentInterface(String identifier, double amt) {
		// TODO Auto-generated method stub
		PaymentInterface pi = pir.getPaymentInterface(identifier);
		pi.pay(amt);
	}
	
}
