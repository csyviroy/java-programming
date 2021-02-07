package com.example.auctionhouse.payment;

import java.util.*;

import com.example.auctionhouse.ioservice.FileObject;
import com.example.auctionhouse.userprofile.UserProfile;

interface PaymentAction{
	public void addPaymentType(PaymentType p);
	public void deletePaymentType(PaymentType p);
}

interface viewPaymentAction {
	public List<PaymentType> getPayment();
	public PaymentType getPayment(String id);
}

public class PaymentTypeRepository extends FileObject<PaymentType> implements PaymentAction, viewPaymentAction {
	private String fileName;
	private List<PaymentType> pList;
	
	PaymentTypeRepository(String fileName){
		this.fileName = fileName;
		this.pList = fileReadObject(this.fileName);
		if (this.pList == null){
			this.pList = new ArrayList<PaymentType>();
			System.out.println("Unable to find existing file, payment profile start fresh.");
		}
		else {
			System.out.println("System file managed to read payment profile.");
		}
	}
	
	@Override
	public List<PaymentType> getPayment() {
		// TODO Auto-generated method stub
		return this.pList;
	}
	
	@Override
	public PaymentType getPayment(String paymentID) {
		// TODO Auto-generated method stub
		Iterator i = this.pList.iterator();
		while (i.hasNext()) {
			PaymentType dbPayment = (PaymentType) i.next();
			if (dbPayment.getPaymentID().equals(paymentID)) {
				return dbPayment;
			}
		}
		return null;
	}

	@Override
	public void addPaymentType(PaymentType p) {
		// TODO Auto-generated method stub
		this.pList.add(p);
		boolean result = fileWriteObject(this.pList, this.fileName);
		if (!result) {
			System.out.println("Adding of payment profile failed");
		}
	}

	@Override
	public void deletePaymentType(PaymentType p) {
		// TODO Auto-generated method stub
		Iterator i = this.pList.iterator();
		while (i.hasNext()) {
			PaymentType payment = (PaymentType) i.next();
			if (payment.getPaymentID().equals(p.getPaymentID())) {
				this.pList.remove(payment);
				break;
			}
		}
		boolean result = fileWriteObject(this.pList, this.fileName);
		if (!result) {
			System.out.println("Deleting of payment profile failed");
		}
	}
	
}
