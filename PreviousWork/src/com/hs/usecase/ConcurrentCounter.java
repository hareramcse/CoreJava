package com.hs.usecase;


public class ConcurrentCounter implements Runnable {
	static volatile int counter = 1;
	static Object counterLock = new Object();

	static void incrementCounter() {
		synchronized (counterLock) {
			System.out.println(Thread.currentThread().getName() + " "
					+ counter);
			counter++;
		}
	}
	@Override
	public void run() {
		while (counter < 100) {
			incrementCounter();
		}
	}

	public static void main(String[] args) {
		ConcurrentCounter cc = new ConcurrentCounter();
		Thread thread1 = new Thread(cc);
		Thread thread2 = new Thread(cc);
		Thread thread3 = new Thread(cc);
		Thread thread4 = new Thread(cc);
		Thread thread5 = new Thread(cc);
		Thread thread6 = new Thread(cc);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}