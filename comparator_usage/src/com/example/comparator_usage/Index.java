package com.example.comparator_usage;

import java.util.*;

public class Index {
	public static void main(String []args) {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("Viroy", 26, 0));
		l.add(new Person("Jack", 25, 1020));
		l.add(new Person("Tim", 21, 2000));
		
		//To use collections list sort, the class must implements comparable or comparator
		
		//Calling this sorting method, uses the comparable method compareTo
		//Collections.sort(l);
		
		//Calling this sorting method, uses the comparator method compare
		Collections.sort(l, new Person());
		for(Person a: l)   // printing the sorted list of ages 
			System.out.print(a.getName() +"  : "+ a.getAge() + ", ");
	}
}
