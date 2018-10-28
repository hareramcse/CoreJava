package com.hs.enumm;

enum Test /* extends Thread */{
	instance {
		public void test() {
			System.out.println("hello");
		}
	},

	instance1("this is instance");

	Test() {
		System.out.println("Default");
	}

	public void test() {
		System.out.println("Hi");
	}

	String val = null;

	Test(String s) {
		this.val = s;
		System.out.println("Argumented");
	}

	String getValue() {
		return val;
	}
}

public class EnumTest {
	public static void main(String[] args) {

		/*Test t = Test.instance;
		Test t1 = Test.instance1;
		t.test();
		t1.test();*/

		//System.out.println(Test.instance1);
		Test t2 = Test.instance1;
		System.out.println(t2.getValue());
	}
}