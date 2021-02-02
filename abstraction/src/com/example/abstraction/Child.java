package com.example.abstraction;

public class Child extends Parent{

	void setFatherName(String name) {
		this.FatherName = name;
	}
	
	@Override
	void setMotherName(String name) {
		// TODO Auto-generated method stub
		this.MotherName = name;
	}

	@Override
	String getMotherName() {
		// TODO Auto-generated method stub
		return this.MotherName;
	}

}
