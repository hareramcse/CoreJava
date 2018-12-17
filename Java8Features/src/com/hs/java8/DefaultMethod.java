package com.hs.java8;

interface Left {
	default void m1() {
		System.out.println("Default left interface method");
	}
}

interface Right {
	default void m1() {
		System.out.println("Default right interface method");
	}
}

public class DefaultMethod implements Left, Right {
	public void m1() {
		Left.super.m1();
	}

	public static void main(String[] args) {
		DefaultMethod d = new DefaultMethod();
		d.m1();
	}
}
