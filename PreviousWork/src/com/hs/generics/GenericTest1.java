package com.hs.generics;

class C<X> {
	X i;
}

public class GenericTest1 {
	public static void main(String[] args) {
		C<String> c1 = new C<String>();
		c1.i = "abc";
		System.out.println(c1.i);
		C<Integer> c2 = new C<Integer>();
		c2.i = 10;
		System.out.println(c2.i);
	}
}
