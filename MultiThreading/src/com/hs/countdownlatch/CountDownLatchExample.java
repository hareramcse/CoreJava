package com.hs.countdownlatch;

import java.util.concurrent.CountDownLatch;

class MyThread extends Thread {

	private final String name;
	private final CountDownLatch latch;

	public MyThread(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	public void run() {
		System.out.println(name + " starting");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		// thread ready. decrement latch counter.
		System.out.println(name + " ready");
		latch.countDown();
	}
}

public class CountDownLatchExample {

	public static void main(String args[]) {

		final CountDownLatch latch = new CountDownLatch(3);

		// create three threads passing a CountDownLatch
		Thread T1 = new Thread(new MyThread("First Thread", latch));
		Thread T2 = new Thread(new MyThread("Second Thread", latch));
		Thread T3 = new Thread(new MyThread("Third Thread", latch));

		// start all three threads
		T1.start();
		T2.start();
		T3.start();

		// wait for latch count to reach zero.
		try {
			latch.await();
		} catch (InterruptedException ie) {
		}

		// The system is ready to go
		System.out.println("All threads are ready");

	}
}
