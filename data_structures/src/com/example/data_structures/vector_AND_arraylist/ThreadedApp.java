package com.example.data_structures.vector_AND_arraylist;

import java.util.*;
import java.sql.Timestamp;

public class ThreadedApp {
	public static void main(String []args) {
		//The vector example shows that multiple threads attempt to interact with the Vector but get locked
		Vector v = new Vector();		
		RunnableVectorCustom v1 = new RunnableVectorCustom("Vector-1", 1, v);
		v1.start();
		RunnableVectorCustom v2 = new RunnableVectorCustom("Vector-2", 2, v);
		v2.start();
		RunnableVectorListCustom v3 = new RunnableVectorListCustom("Vector-3", 3, v);
		v3.start();
		
		
		//The arraylist example shows that multiple threads attempt to interact with the ArrayList at the same time
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		RunnableArrayListCustom al1 = new RunnableArrayListCustom("ArrayList-1", 1, al);
//		al1.start();		
//		RunnableArrayListCustom al2 = new RunnableArrayListCustom("ArrayList-2", 2, al);
//		al2.start();
//		RunnableArrayListListingCustom al3 = new RunnableArrayListListingCustom("ArrayList-3", 3, al);
//		al3.start();
	}
}

class RunnableVectorListCustom implements Runnable{
	private Thread t;
	private String threadName;
	private Vector v;
	private int index;

	public RunnableVectorListCustom(String name, int i, Vector associatedV) {
		this.threadName = name;
		this.v = associatedV;
		this.index = i;
		System.out.println("Creating thread: " + name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Thread: " + this.threadName);
		
		for (int a =0; a<100; a++) {
			System.out.println("Cycle " + a);
			this.v.forEach((n) -> {
				System.out.println(n);
			});
		}
		
		System.out.println("Thread " +  this.threadName + " exiting.");	
	}
	
	void start() {
	      System.out.println("Starting " +  this.threadName );
	      if (this.t == null) {
	         this.t = new Thread (this, threadName);
	         this.t.start ();
	      }
	}
}


class RunnableVectorCustom implements Runnable{
	private Thread t;
	private String threadName;
	private Vector v;
	private int index;

	public RunnableVectorCustom(String name, int i, Vector associatedV) {
		this.threadName = name;
		this.v = associatedV;
		this.index = i;
		System.out.println("Creating thread: " + name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Thread: " + this.threadName);
		
		for (int i = 0; i < 100; i++) {
			
			
			System.out.println("Thread: " + this.threadName + " showing vector content: " + this.v);
			if (this.v.size() > 10) {
				this.v.clear();
				Date date = new Date();    
				System.out.println( new Timestamp(date.getTime()) + " - Thread: " + this.threadName + " remove all element from vector");
			}
			else {
				this.v.add(i*this.index);
				Date date = new Date();
				System.out.println(new Timestamp(date.getTime()) + " - Thread: " + this.threadName + " add i: " + i*this.index + " to vector");
			}
			
			
			//Sleep can be toggle to see the full effect of the thread on Vector
			//When sleep is commented, thread 1 will run finish then thread 2 will run because vector is synchronized which mean
			//it will lock the vector if 1 thread is performing structural modification.
//			try {
//				Thread.sleep(this.index);
//			} catch (InterruptedException e) {
//		         System.out.println("Thread " +  this.threadName + " interrupted.");
//		    }
		}
		System.out.println("Thread " +  this.threadName + " exiting.");	
	}
	
	void start() {
	      System.out.println("Starting " +  this.threadName );
	      if (this.t == null) {
	         this.t = new Thread (this, threadName);
	         this.t.start ();
	      }
	}
}


class RunnableArrayListListingCustom implements Runnable{

	private Thread t;
	private String threadName;
	private ArrayList al;
	private int index;

	public RunnableArrayListListingCustom(String name, int i, ArrayList associatedAL) {
		this.threadName = name;
		this.al = associatedAL;
		this.index = i;
		System.out.println("Creating thread: " + name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Thread: " + this.threadName);
		
		for (int a = 0; a < 100; a++) {
			System.out.println("Cycle " + a);
			this.al.forEach((n)-> {
				System.out.println(n);
			});
		}
		
		System.out.println("Thread " +  this.threadName + " exiting.");	
	}
	
	void start() {
	      System.out.println("Starting " +  this.threadName );
	      if (this.t == null) {
	         this.t = new Thread (this, threadName);
	         this.t.start ();
	      }
	}
	
}

class RunnableArrayListCustom implements Runnable{

	private Thread t;
	private String threadName;
	private ArrayList al;
	private int index;

	public RunnableArrayListCustom(String name, int i, ArrayList associatedAL) {
		this.threadName = name;
		this.al = associatedAL;
		this.index = i;
		System.out.println("Creating thread: " + name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Thread: " + this.threadName);
		
		for (int i = 0; i < 100; i++) {
			
			System.out.println("Thread: " + this.threadName + " showing vector content: " + this.al);
			if (this.al.size() > 10) {
				this.al.clear();
				Date date = new Date();
				System.out.println(new Timestamp(date.getTime()) + " - Thread: " + this.threadName + " remove all element from ArrayList");
			}
			else {
				this.al.add(i*this.index);
				Date date = new Date();
				System.out.println( new Timestamp(date.getTime()) + " - Thread: " + this.threadName + " add i: " + i*this.index + " to ArrayList");
			}
			
			
			//Sleep can be toggle to see the full effect of the thread on Vector
			//When sleep is commented, thread 1 will run finish then thread 2 will run because vector is synchronized which mean
			//it will lock the vector if 1 thread is performing structural modification.
//			try {
//				Thread.sleep(this.index);
//			} catch (InterruptedException e) {
//		         System.out.println("Thread " +  this.threadName + " interrupted.");
//		    }
		}
		System.out.println("Thread " +  this.threadName + " exiting.");	
	}
	
	void start() {
	      System.out.println("Starting " +  this.threadName );
	      if (this.t == null) {
	         this.t = new Thread (this, threadName);
	         this.t.start ();
	      }
	}
	
}