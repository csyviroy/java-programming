package com.example.auctionhouse.payment;

import java.util.Date;

interface PaymentInteraction{
	public void createPaymentMethod(String paymentType);
	public void deletePaymentMethod(String uniqueID);
	public void viewPaymentMethod(String uniqueID);
	public void viewPaymentMethodList();
	public void paymentPay();
}

public class PaymentTypeService implements PaymentInteraction{

	@Override
	public void createPaymentMethod(String paymentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePaymentMethod(String uniqueID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPaymentMethod(String uniqueID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPaymentMethodList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymentPay() {
		// TODO Auto-generated method stub
		
	}


}
