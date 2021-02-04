package com.example.comparator_usage;

import java.util.*;

public class Person implements Comparator<Person>, Comparable<Person>{
	private double salary;
	private int age;
	private String name;
	
	Person(){
		
	}
	
	Person(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	//Used by Comparator
	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

	//Used by Comparable
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return (this.name).compareTo(o.name);
	}
}
