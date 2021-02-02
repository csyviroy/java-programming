package com.example.data_structures.bit_set;

import java.util.BitSet;

public class Index {
	public static void main(String []args) {
		
		//given a BitSet bit, it can be use to do xor, or, and, andnot operation with other BitSet bit
		
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet(8);
		
		System.out.println("bs1 length: " + bs1.length());
		System.out.println("bs1: " + bs1);
		System.out.println("bs2 length: " + bs2.length());
		System.out.println("bs2: " + bs2);
		
		for(int i = 0; i < 16; i++) {
			if((i % 2) == 0) bs1.set(i);
			bs2.set(i);
		}
		
		System.out.println("bs1 length: " + bs1.length());
		System.out.println("bs1 size: " + bs1.size());
		System.out.println("bs1: " + bs1);
		System.out.println("bs1 string: " + bs1.toString());
		
		System.out.println();
		
		System.out.println("bs2 length: " + bs2.length());
		System.out.println("bs2 size: " + bs2.size());
		System.out.println("bs2: " + bs2);
		System.out.println("bs2 string: " + bs2.toString());
		bs1.flip(0,5);
		System.out.println("bs1 flip: " + bs1);
	}
}
