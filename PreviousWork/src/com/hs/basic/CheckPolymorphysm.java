package com.hs.basic;

class A {
	int i;

	public void run() {
		System.out.println("run from A");
	}

	public void test() {
		System.out.println("test from A");
	}

	public Number rest() {
		return 10;
	}
}

class B extends A {
	int i=5;

	public void run() {
		System.out.println("run from B");
	}

	public void fest() {
		System.out.println("fest from B");
	}

	// we can not up cast in return type. here it should be subclass of the
	// parent method return type
	public Integer rest() {
		return 20;
	}
}

public class CheckPolymorphysm {
	public static void main(String[] args) {
		A a1 = new A();
		a1.run();
		a1.test();
		System.out.println(a1.i);
		System.out.println("...................");

		B b1 = new B();
		b1.run();
		b1.test();
		System.out.println(b1.i);
		System.out.println(a1.i);
		System.out.println("....................");

		A a2 = new B();
		a2.run();
		a2.test();
		System.out.println(a2.i);
		// a2.fest();
		// System.out.println(a2.j);
		B b2 = (B) a2;
		b2.test();
		b2.fest();
		System.out.println(b2.i);

		System.out.println(".................");
		A a3 = new B();
		System.out.println(a3.rest());
		a3.test();
		B b3 = (B) a3;
		System.out.println(b3.rest());
	}
}