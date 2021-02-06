package com.example.single_responsibility_principle;


interface GoodsManagement {

	public void improveQuality();
	public void deteriorateQuality();
	
}

public class AuctionedGood implements GoodsManagement{
	enum QUALITY{
		POOR,
		FAIR,
		GOOD,
		PERFECT
	}
	private QUALITY q;
	private String itemName;
	private Integer quantity;
	private String ownerName;
	private String bidderName = null;
	private double bidderAmount = 0;

	AuctionedGood(String ownerName, String itemName, QUALITY q, Integer quantity){
		this.ownerName = ownerName;
		this.itemName = itemName;
		this.q = q;
		this.quantity = quantity;
	}
	
	void updateBidder(String bidderName, double amt) {
		this.bidderName = bidderName;
		this.bidderAmount = amt;
	}
	
	public void improveQuality() {
		if (this.q.ordinal() < QUALITY.values().length-1) {
			this.q = QUALITY.values()[this.q.ordinal()+1];
		}
	}
	
	public void deteriorateQuality() {
		if (this.q.ordinal() > 0) {
			this.q = QUALITY.values()[this.q.ordinal()-1];
		}
	}
	
	void updateQuantity(int nowQuantity) {
		this.quantity = nowQuantity;
	}
	
	String getBidderName() {
		return this.bidderName;
	}
	
	double getBidderAmt() {
		return this.bidderAmount;
	}
	
	String getOwnerName() {
		return this.ownerName;
	}
	
	String getItemName() {
		return this.itemName;
	}
	
	QUALITY getQuality() {
		return this.q;
	}
	
	Integer getQuantity() {
		return this.quantity;
	}
}
