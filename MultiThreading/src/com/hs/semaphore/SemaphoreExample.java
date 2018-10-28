package com.hs.semaphore;

import java.util.concurrent.Semaphore;

// A semaphore can be thought off as a key to a car. One person acquires the key to the car and drives it, 
//while the other person waits. After the first person is done driving, they still have the key, 
//so the second person has to wait until the first person releases the key to be used by somebody else. 
public class SemaphoreExample {

	static int counter = 0;
	static Semaphore semaphore = new Semaphore(1);

	public static void incrementCounter() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()
					+ " took the lock key");
			counter++;
			semaphore.release();
			System.out.println(Thread.currentThread().getName()
					+ " released the lock key");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Thread firstThread = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					incrementCounter();
				}

			}
		};

		Thread secondThread = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					incrementCounter();
				}

			}
		};

		firstThread.start();
		secondThread.start();

		while (firstThread.isAlive() || secondThread.isAlive()) {
		}

		System.out.println("Counter : " + counter);

	}
}