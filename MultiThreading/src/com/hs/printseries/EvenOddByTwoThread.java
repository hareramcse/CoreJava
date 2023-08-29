package com.hs.printseries;

class Odd implements Runnable {
	Object lock;

	Odd(Object lock) {
		this.lock = lock;
	}

	public void run() {
		for (int i = 1; i < 100; i = i + 2) {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				try {
					lock.notify();
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Even implements Runnable {
	Object lock;

	Even(Object lock) {
		this.lock = lock;
	}

	public void run() {
		for (int i = 2; i < 100; i = i + 2) {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				try {
					lock.notify();
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class EvenOddByTwoThread {

	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1 = new Thread(new Odd(lock));
		t1.setName("Odd Thread");
		Thread t2 = new Thread(new Even(lock));
		t2.setName("Even Thread");

		try {
			t1.start();
			t2.start();
			t2.join();
		} catch (Exception e) {
			System.out.println("exception occured");
		}
		System.out.println();
		System.out.println("Main Over");
	}
}