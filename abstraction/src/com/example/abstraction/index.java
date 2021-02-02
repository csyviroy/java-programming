package com.example.abstraction;

public class index {
	public static void main(String [] args) {
		Child c = new Child();
		System.out.println(new Child().getFatherName());
		System.out.println(c.getFatherName());
		
		c.setFatherName("magic name");
		System.out.println(c.getFatherName());
		System.out.println(c.getMotherName());
		c.setMotherName("meme");
		System.out.println(c.getMotherName());
		
		
		Child c1 = new Child();
		Parent p = new Child();
		System.out.println(p.FatherName);
		//Sibling s = c1;
		//Sibling s = (Sibling) p;
		//System.out.println(s.FatherName);
	}
}
