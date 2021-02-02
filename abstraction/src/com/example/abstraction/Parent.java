package com.example.abstraction;

public abstract class Parent {
	String FatherName = "keke";
	String MotherName = "lele";
	
	void setFatherName(String name) {
		this.FatherName = name;
	}
	
	String getFatherName() {
		return this.FatherName;
	}
	
	abstract void setMotherName(String name);
	
	abstract String getMotherName();
	
	
}
