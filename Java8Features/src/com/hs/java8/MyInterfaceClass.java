package com.hs.java8;

public class MyInterfaceClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	// MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.print("abc");
	}

	public static void main(String[] args) {
		MyInterfaceClass clss = new MyInterfaceClass();
		clss.log("app");

		Interface1 i1 = (s) -> System.out.println("hello this is Hareram");
		System.out.println(i1);
	}
}