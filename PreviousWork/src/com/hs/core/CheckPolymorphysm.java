package com.hs.core;

class A {
	int i = 10;

	public void run() {
		System.out.println("run from A");
	}

	public static void fest() {
		System.out.println("static fest from A");
	}

	public void test() {
		System.out.println("test from A");
	}
}

class B extends A {
	int i = 20;
	int j = 30;

	public void run() {
		System.out.println("run from B");
	}

	public static void fest() {
		System.out.println("static fest from B");
	}

	public void rest() {
		System.out.println("rest from B");
	}
}

public class CheckPolymorphysm {
	public static void main(String[] args) {
		A a1 = new A();
		a1.run();
		a1.test();
		A.fest();
		// a1.rest();
		System.out.println(a1.i);
		System.out.println("...................");
		System.out.println("...................");
		B b1 = new B();
		b1.run();
		b1.test();
		b1.rest();
		B.fest();
		System.out.println(b1.i);
		System.out.println(b1.j);
		System.out.println("....................");
		System.out.println("....................");
		A a2 = new B();
		a2.run();
		a2.test();
		A.fest();
		// a2.rest();
		System.out.println(a2.i);
		// System.out.println(a2.j);
		System.out.println("....................");
		System.out.println("....................");
		B b2 = (B) a2;
		b2.test();
		b2.rest();
		B.fest();
		System.out.println(b2.j);
		System.out.println(b2.i);
	}
}