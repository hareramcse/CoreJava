package com.hs.java8;

interface I1 {
	public void m1();
}

public class Demo1 {
	public static void main(String[] args) {
		I1 t1 = ()->System.out.println("hello with lambda");
		t1.m1();
	}
}
