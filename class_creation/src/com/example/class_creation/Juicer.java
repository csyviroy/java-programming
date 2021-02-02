package com.example.class_creation;
import com.example.class_creation.*;
public class Juicer {
	Fruit fruit;
	
	Juicer(Fruit fruit){
		this.fruit = fruit;
	}
	
	String getFruit() {
		return fruit.getName();
	}
	
	String squeeze(){
		return this.fruit.getName() + " juice";
	}
}
