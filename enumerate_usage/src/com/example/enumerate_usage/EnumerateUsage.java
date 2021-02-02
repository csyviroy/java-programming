package com.example.enumerate_usage;

public class EnumerateUsage {
	public static void main(String []args) {
		Juice john = new Juice();
		john.setSize(Juice.CupSize.MEDIUM);
		System.out.println(john.getSize());
	}
}

class Juice {
	enum CupSize{ SMALL, MEDIUM, LARGE }
	CupSize size;
	
	public void setSize(CupSize size) {
		this.size = size;
	}
	
	public CupSize getSize() {
		return this.size;
	}
}
