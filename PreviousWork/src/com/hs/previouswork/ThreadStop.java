package com.hs.previouswork;

class Thread1 extends Thread {
	public volatile boolean flag = true;

	public void terminate() {
		flag = false;
	}

	public void run() {
		while (flag) {
			System.out.println("hello from thread1");
		}
	}
}

public class ThreadStop {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		t1.terminate();
		System.out.println(t1.getState());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// t1.stop();
		System.out.println(t1.getState());
	}
}
