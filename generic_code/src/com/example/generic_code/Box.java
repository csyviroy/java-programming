package com.example.generic_code;

public class Box<T> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T getT() {
		return this.t;
	}
}
