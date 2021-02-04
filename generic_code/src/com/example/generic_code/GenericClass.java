package com.example.generic_code;

public class GenericClass {
	public static void main(String []args) {
		Box<String> stringBox = new Box<String>();
		stringBox.add("HelloWorld");
		
		Box<Box> boxBox = new Box<Box>();
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.add(50);
		boxBox.add(integerBox);
		
		System.out.println("stringBox: " + stringBox.getT());
		System.out.println("boxBox: " + boxBox.getT());
		System.out.println("boxBox -> integerBox: " + boxBox.getT().getT());
	}
}
