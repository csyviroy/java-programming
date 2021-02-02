package com.example.non_access_modifier_transient;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MoneyCalculator {
	public static void main(String [] args) {
		String filename = "last_total.ser";
		
		Calculator cal = new Calculator();
		System.out.println(cal.getUserID());
		cal.generateSession();
		System.out.println(cal.getUserID());
		cal.add(5);
		cal.add(1);
		cal.displayTotal();
		cal.subtract(1);
		cal.multiply(2);
		cal.displayTotal();
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(cal);
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
