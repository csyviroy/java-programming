package com.example.data_structures.vector_AND_arraylist;

import java.util.*;

public class Index {
	public static void main(String [] args) {
		//Vector
		//Similar to ArrayList but difference:
		//1. Synchronization
			//Vector is synchronized, but ArrayList is not
			//If 2 threads use the same vector variable, 1 thread will be locked
			//Potentially make ArrayList perform faster than Vector
		//2. Vector contain many legacy methods that are not part of the collections framework
		
		
		//Default vector size is 10
		Vector v = new Vector();
		//Setting 3 as the initial size and 2 as the incremental size, this mean if vector size increase, it will be increase by +2
		//Vector v = new Vector(3,2);
		v.add("Hello world");
		v.add(5);
		v.add(10);

		System.out.println("vector size: " + v.capacity());
		
		if (v.contains("Hello world"))
			System.out.print("found it");
		
		if (v.contains(5))
			System.out.println("Found integer");
		
		Iterator i = v.iterator();
		
		while (i.hasNext()) {
			System.out.println(i.next());
			
		}
		
		//or
		
		v.forEach((n) -> {
			System.out.println(n);
		});
		
		//exception occur, structure modification occur while iterating through (Fail Fast)
//		Vector b = v;
//		b.forEach((n) -> {
//			System.out.println(n);
//			v.add(20);
//		});
		
		//ArrayList
		ArrayList<String> al = new ArrayList<String>();
		al.add("test1");
		al.add("test2");
		System.out.println(al);
		
		for (String z:al) {
			System.out.println(z);
		}
		
		//or
		
		al.forEach((a)->{
			System.out.println(a);
		});
		
	}
}
