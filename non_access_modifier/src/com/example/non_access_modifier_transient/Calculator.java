package com.example.non_access_modifier_transient;

import java.io.Serializable;

interface CalculatorAdd {
	public void add(int a);
}

interface CalculatorSub {
	public void subtract(int a);
}

interface CalculatorMultiply {
	public void multiply(int a);
}

interface CalculatorDivide {
	public void divide(int a);
}

interface UserSessionGenerator{
	public void generateSession();
}

public class Calculator implements Serializable, UserSessionGenerator, CalculatorAdd, CalculatorSub, CalculatorMultiply, CalculatorDivide{
	transient int user_id = 0;
	int total = 0;

	public void generateSession() {
		this.user_id = (int) Math.random() + 4;
	}
	
	public int getUserID() {
		return user_id;
	}
	
	public void add(int a) {
		total += a;
	}
	
	public void subtract(int a) {
		total -= a;
	}
	
	public void multiply(int a) {
		total *= a;
	}
	
	public void divide(int a) {
		total /= a;
	}
	
	public void displayTotal() {
		System.out.println(this.total);
	}
	
	public void clear() {
		this.total = 0;
	}
}
