package com.example.class_creation;

public class Fruit {
	String country;
	String location;
	String color;
	String name;
	
	Fruit(String country, String location, String color){
		this.name = null;
		this.country = country;
		this.location = location;
		this.color = color;
	}
	
	void setCountry(String country) {
		this.country = country;
	}
	
	String getCountry(String country) {
		return this.country;
	}
	
	void setLocation(String location) {
		this.location = location;
	}
	
	String getLocation() {
		return this.location;
	}
	
	void setColor(String color) {
		this.color = color;
	}
	
	String getColor() {
		return this.color;
	}
	
	void setName() {
		this.name = "fruit";
	}
	
	String getName() {
		return this.name;
	}
}
