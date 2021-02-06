package com.example.single_responsibility_principle;

import com.example.single_responsibility_principle.AuctionedGood.QUALITY;

public class CustomAuctionHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * This custom auction house allows customer to view the item and set their price. After the selling period, the highest offer will be taken.
		 * 
		 * From this auction house example,
		 * One can simply create a AuctionHouse class which have the display good and price and make transaction method,
		 * But doing so will violate the SRP of SOLID principles
		 * 
		 * To follow SRP principle, one need to separate AuctionHouse class into multiple components
		 * 1. AuctionItemManager <- due with the showing customer the auction item and current price
		 * 2. TransactionManager <- allow customer to make the transaction after the selling period
		 * 
		 */
		
		AuctionItemManager aim = new AuctionItemManager();
		int registerID = aim.registerGood("Viroy", "Basket Ball", QUALITY.FAIR, 1);
		System.out.println(registerID);
		aim.viewAuctionItem();
		
		aim.bid(1, "Jack", 20);
		aim.viewAuctionItem();
		
		aim.polish(1);
		aim.viewAuctionItem();
		
		AuctionTransactionManager atm = new AuctionTransactionManager();
		atm.payment(registerID, aim);
		
		aim.viewAuctionItem();
	}

}
