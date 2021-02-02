package com.example.data_structures.enumeration;

import java.util.Enumeration;
import java.util.Vector;
import java.lang.reflect.Array;

public class Index {
	public static void main(String [] args) {
		System.out.println(System.getProperty("java.runtime.version"));
		
		//working with vector
		Vector v = new Vector();
		v.add("Oi");
		v.add("I");
		v.add("am");
		v.add("working");
		Enumeration e = v.elements();
		while (e.hasMoreElements())
			System.out.print(e.nextElement());
		//enumeration class is similar to a pointer that will move along the variable until the end. After the end, it will not have next element.
		//System.out.println(e.nextElement());
		
		System.out.println();
		
		//working with String array
		//need to create custom enum class
		String[] words = new String[5];
		words[0] = "Hello";
		words[1] = "World!";
		words[2] = "I";
		words[3] = "am";
		words[4] = "Viroy~";
		
		e = makeEnumeration(words);
		while (e.hasMoreElements())
			System.out.print(e.nextElement());
		
	}
	
	static public Enumeration makeEnumeration(final Object obj) {
		Class type = obj.getClass();
		if (!type.isArray()) {
			throw new IllegalArgumentException(obj.getClass().toString());
		}
		else {
			return (new Enumeration() {
				int size = Array.getLength(obj);
				int cursor = 0;
				
				public boolean hasMoreElements() {
					return cursor < size;
				}
				
				public Object nextElement() {
					return Array.get(obj, cursor++);
				}
			});
		}
	}
}

