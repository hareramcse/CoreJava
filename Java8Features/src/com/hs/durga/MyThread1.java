package com.hs.durga;

public class MyThread1 {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child thread " + i);
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread " + i);
		}
	}
}
