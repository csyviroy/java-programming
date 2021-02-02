package com.example.access_modifier;

import world.apple;

class pear {
	String color="Green";
	String accessibility;
	
	public void printHelloWorld() {
		System.out.print("Hello World!");
		//Can access public apple
		apple a = new apple();
		//Can access apple public method
		a.printHelloWorld();
		//Cannot access apple private method
		//a.getAppleColor();
		//Cannot access apple protect method
		//a.setAccessibility("Protected");
	}
	
	private String getPearColor() {
		return this.color;
	}
	
	protected void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
		//Can call private method
		this.getPearColor();
	}
}
