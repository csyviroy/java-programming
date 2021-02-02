package com.example.class_creation;
import com.example.class_creation.*;

public class JuicerShop {
	public static void main(String []args) {
		//new order
		Fruit fruitA = new Strawberry("Thailand", "East", "White");
		fruitA.setName();
		Juicer machineA = new Juicer(fruitA);
		//check if fruitA is in machineA
		System.out.println(machineA.getFruit());
		System.out.println(machineA.squeeze());
		
		
		Fruit fruit = new Orange("Singapore", "West", "Orange");
		fruit.setName();
		System.out.println(fruit.getName());
		Orange o = (Orange) fruit;
		System.out.println(o.getName());
	}
}
