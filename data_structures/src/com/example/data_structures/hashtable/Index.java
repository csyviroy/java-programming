package com.example.data_structures.hashtable;

import java.util.*;

public class Index {
	public static void main(String [] args) {
		Hashtable<String, Double> ht = new Hashtable();
		Enumeration names;
		String str;
		
		ht.put("jack", 34.26);
		ht.put("Tom", 25.25);
		ht.put("Mee", 10.51);
		
		names = ht.keys();
		
		while (names.hasMoreElements()) {
			String individual = names.nextElement().toString();
			System.out.println("Individual: " + individual + " have " + ht.get(individual));
		}
	}
}
