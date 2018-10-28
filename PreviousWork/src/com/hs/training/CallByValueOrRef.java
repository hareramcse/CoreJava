package com.hs.training;

public class CallByValueOrRef {
	Integer i;
	Integer j;

	String s1;
	String s2;

	CallByValueOrRef(Integer i, Integer j) {
		this.i = i;
		this.j = j;
	}

	CallByValueOrRef(int i, int j) {
		this.i = i;
		this.j = j;
	}

	CallByValueOrRef(String i, String j) {
		this.s1 = i;
		this.s2 = j;
	}

	public void swap(Integer x, Integer y) {
		Integer temp = x;
		x = y;
		y = temp;
		System.out.println(x + ".." + y);
	}

	public void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.println(x + ".." + y);
	}

	public void swap(String x, String y) {
		String temp = x;
		x = y;
		y = temp;
		System.out.println(x + ".." + y);
	}

	public static void main(String[] args) {
		Integer x = 5;
		Integer y = 8;
		CallByValueOrRef cf = new CallByValueOrRef(x, y);
		cf.swap(x, y);
		System.out.println(x + "  .. " + y);

		int a = 6;
		int b = 9;
		CallByValueOrRef cf1 = new CallByValueOrRef(a, b);
		cf1.swap(a, b);

		System.out.println(a + ".." + b);

		String p = "abc";
		String q = "pqr";
		CallByValueOrRef cf2 = new CallByValueOrRef(p, q);
		cf2.swap(p, q);
		System.out.println(p + "...." + q);
	}
}
