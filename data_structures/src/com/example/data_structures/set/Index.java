package com.example.data_structures.set;

import java.util.*;

public class Index {
	public static void main(String []args) {
		int[] count = {5, 20, 5, 10, 15};
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i< 5; i++) {
			s.add(count[i]);
		}
		System.out.println(s);

        TreeSet sortedSet = new TreeSet<Integer>(s);
        System.out.println("The sorted list is:");
        System.out.println(sortedSet);

        System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
        System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
	}
}
