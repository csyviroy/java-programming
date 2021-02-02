package com.example.non_access_modifier_transient;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadCalculator {
	public static void main(String []args) {
		String filename = "last_total.ser";
		
		Calculator cal = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			cal = (Calculator)in.readObject();
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(cal.getUserID());
		cal.displayTotal();
		
	}
}
