package com.hs.durga;

class Test {
	Test() {
		System.out.println("test class constructor is called");
	}
}

interface Add {
	public Test get();
}

public class MySecondMethodReference {

	public static void main(String[] args) {
		Add add = Test::new;
		Test test = add.get();
	}
}
