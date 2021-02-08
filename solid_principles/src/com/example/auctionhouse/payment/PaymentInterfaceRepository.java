package com.example.auctionhouse.payment;

import java.util.*;
import com.example.auctionhouse.ioservice.FileObject;

interface PaymentInterfaceAction{
	public void addPaymentInterface(PaymentInterface p);
	public void deletePaymentInterface(PaymentInterface p);
}

interface viewPaymentInterfaceAction {
	public List<PaymentInterface> getPaymentInterfaceList();
	public PaymentInterface getPaymentInterface(String id);
}

public class PaymentInterfaceRepository extends FileObject<PaymentInterface> implements PaymentInterfaceAction, viewPaymentInterfaceAction {
	private String fileName;
	private List<PaymentInterface> pList;
	
	PaymentInterfaceRepository(String fileName){
		this.fileName = fileName;
		this.pList = fileReadObject(this.fileName);
		if (this.pList == null){
			this.pList = new ArrayList<PaymentInterface>();
			System.out.println("Unable to find existing file, payment profile start fresh.");
		}
		else {
			System.out.println("System file managed to read payment profile.");
		}
	}
	
	@Override
	public List<PaymentInterface> getPaymentInterfaceList() {
		// TODO Auto-generated method stub
		return this.pList;
	}
	
	@Override
	public PaymentInterface getPaymentInterface(String identifier) {
		// TODO Auto-generated method stub
		Iterator i = this.pList.iterator();
		while (i.hasNext()) {
			PaymentInterface dbPayment = (PaymentInterface) i.next();
			if (dbPayment.getIdentitifer().equals(identifier)) {
				return dbPayment;
			}
		}
		return null;
	}

	@Override
	public void addPaymentInterface(PaymentInterface p) {
		// TODO Auto-generated method stub
		this.pList.add(p);
		boolean result = fileWriteObject(this.pList, this.fileName);
		if (!result) {
			System.out.println("Adding of payment profile failed");
		}
	}

	@Override
	public void deletePaymentInterface(PaymentInterface p) {
		// TODO Auto-generated method stub
		Iterator i = this.pList.iterator();
		while (i.hasNext()) {
			PaymentInterface payment = (PaymentInterface) i.next();
			if (payment.getIdentitifer().equals(p.getIdentitifer())) {
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
