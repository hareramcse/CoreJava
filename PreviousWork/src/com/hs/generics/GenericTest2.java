package com.hs.generics;

class D<T> {
	String s1;
	T s2;
}

public class GenericTest2 {
	public static void main(String[] args) {
		D<Integer> d1 = new D<Integer>();
		d1.s1 = "abc";
		d1.s2 = 100;
		System.out.println(d1.s2);
		System.out.println(d1.s1);
		D<String> d2 = new D<String>();
		d2.s1 = "def";
		d2.s2 = "200";
		System.out.println(d2.s1);
		System.out.println(d2.s2);
	}
}
