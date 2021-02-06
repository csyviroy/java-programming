package com.example.single_responsibility_principle;

interface Transaction{
	void payment(int id, AuctionItemManager aim);
}

public class AuctionTransactionManager implements Transaction{

	@Override
	public void payment(int id, AuctionItemManager aim) {
		// TODO Auto-generated method stub
		AuctionedGood ag = aim.getAuctionedGoodRecord(id);
		System.out.printf("Thank you very much, %s for purchasing item - %s, condition: %s for %.2f\n", ag.getBidderName(), ag.getItemName(), ag.getQuality(), ag.getBidderAmt());
		//Request aim to update the record
		aim.unregisterGood(id);
	}
	
}
