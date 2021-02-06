package com.example.single_responsibility_principle;

import java.util.*;
import java.util.Map.Entry;

import com.example.single_responsibility_principle.AuctionedGood.QUALITY;

interface registerGood{
	public int registerGood(String ownerName, String itemName, QUALITY q, Integer quantity);
}

interface unregisterGood{
	public void unregisterGood(int id);
}

interface maintanceGood{
	public void polish(int id);
}

interface clientBid{
	public void bid(int id, String bidderName, double bidderAmt);
}

interface getAuctionedItemList{
	public void viewAuctionItem();
}

//AuctionItemManager interact with the item to display the item and existing price of the item
public class AuctionItemManager implements registerGood, unregisterGood, maintanceGood, clientBid, getAuctionedItemList{
	private HashMap<Integer, AuctionedGood> agMap = new HashMap<Integer, AuctionedGood>();
	private int idCount  = 0;
	
	AuctionItemManager() {
	}
	
	public int registerGood(String ownerName, String itemName, QUALITY q, Integer quantity) {
		AuctionedGood ag = new AuctionedGood(ownerName, itemName, q, quantity);
		idCount++;
		agMap.put(idCount, ag);
		System.out.printf("item %d is register successfully\n", idCount);
		return idCount;
	}

	@Override
	public void unregisterGood(int id) {
		// TODO Auto-generated method stub
		this.agMap.remove(id);
		System.out.printf("item %d is removed successfully\n", id);
	}

	@Override
	public void polish(int id) {
		// TODO Auto-generated method stub
		QUALITY existingQuality = this.agMap.get(id).getQuality();
		this.agMap.get(id).improveQuality();
		System.out.printf("item %d quality: %s -> %s\n", id, existingQuality, this.agMap.get(id).getQuality());
	}

	@Override
	public void bid(int id, String bidderName, double bidderAmt) {
		// TODO Auto-generated method stub
		if (bidderAmt > this.agMap.get(id).getBidderAmt())
			this.agMap.get(id).updateBidder(bidderName, bidderAmt);
			System.out.printf("%s successfullly bid for item %d for %.2f\n", bidderName, id, bidderAmt);
	}

	@Override
	public void viewAuctionItem() {
		// TODO Auto-generated method stub
		Iterator it = this.agMap.entrySet().iterator();
		System.out.println("Looking into database...");
		while (it.hasNext()) {
			Map.Entry<Integer, AuctionedGood> pair =  (Entry<Integer, AuctionedGood>) it.next();
			AuctionedGood ag = pair.getValue();
			System.out.printf("item %d - (%s, condition: %s, stock: %d) : bid by %s for %.2f\n", pair.getKey(), ag.getItemName(), ag.getQuality(), ag.getQuantity(), ag.getBidderName(), ag.getBidderAmt());
		}
		System.out.println("End");
	}
	
	public AuctionedGood getAuctionedGoodRecord(int id) {
		return this.agMap.get(id);
	}
}
