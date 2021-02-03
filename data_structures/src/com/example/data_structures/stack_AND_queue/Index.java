package com.example.data_structures.stack_AND_queue;

import java.util.*;

public class Index {
	public static void main(String []args) {
		//Stack follow the concept of Last In First Out (LIFO)
		Stack st = new Stack();
		st.push(5);
		st.push("hello world");
		System.out.println(st);
		
		st.pop();
		st.pop();
		if (st.empty()) {
			st.push("It was empty");
		}
		System.out.println(st);
		System.out.println(st.peek());
		st.push("hello world");
		System.out.println(st.peek());
		
		System.out.println();
		
		//Queue follow the concept of First In First Out (FIFO)
		//Queue is an interface, it cannot be initialize like Stack class
		//Object is the root of every class <-- best not to define as Object class since ClassCastException will happen if use different class data
		//Queue<Object> q = new PriorityQueue<Object>();
		//q.add('a');
		//q.add("hello world");
		//System.out.println("Q: " + q);
		
		//Both Priotiy Queue and LinkedList implement Queue interface
		//Priority Queue(pq) vs LinkedList(ll)
		//At time of insertion, pq is sorted and ordered
		//At time of insertion, ll is only ordered
		
		//Priority Queue
		Queue<Integer> q = new PriorityQueue<Integer>(5);
		q.add(10);
		q.add(15);
		q.add(1);
		q.add(20);
		q.add(30);
		
		System.out.println(q.peek());
		int i = q.poll();
		System.out.println("Poll q for " + i);
		
		System.out.println("Q: " + q);
		
		//LinkedList Queue
		Queue<Integer> q2 = new LinkedList<Integer>();
		q2.add(10);
		q2.add(15);
		q2.add(1);
		q2.add(20);
		q2.add(30);
		
		System.out.println(q2.peek());
		int i2 = q2.poll();
		System.out.println("Poll q2 for " + i2);
		
		System.out.println("Q2: " + q2);
		
	}
}
