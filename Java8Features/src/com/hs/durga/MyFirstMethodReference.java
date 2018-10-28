package com.hs.durga;

public class MyFirstMethodReference {
	public static void m1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread " + i);
		}
	}
	public void m2() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread " + i);
		}
	}

	public static void main(String[] args) {
		//Runnable runnable = MyMethodReference::m1;
		
		MyFirstMethodReference methodReference=new MyFirstMethodReference();
		Runnable runnable=methodReference::m2;

		Thread t = new Thread(runnable);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread " + i);
		}
	}
}
