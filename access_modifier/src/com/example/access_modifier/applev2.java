package com.example.access_modifier;

import world.apple;

public class applev2 extends apple{
	protected applev2() {
		//public method
		this.printHelloWorld();
		//protected method
		this.setAccessibility("protected");
		
		//Can access no modifier pear class in the same package
		pear p = new pear();
		//p.getPearColor();
	}
}
