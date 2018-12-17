package com.hs.usecase;

class CyclicBarrier {
	// int initialParties;
	int partiesAwait;

	public CyclicBarrier(int parties) {
		// initialParties = parties;
		partiesAwait = parties;
	}

	public synchronized void await() throws InterruptedException {
		partiesAwait--;
		if (partiesAwait > 0) {
			this.wait();
		} else {
			// partiesAwait = initialParties;
			this.notifyAll();
		}
	}
}

class MyRunnable implements Runnable {
	private String name;
	private int sleep;
	private CyclicBarrier barrier;

	public MyRunnable(String name, int sleep, CyclicBarrier barrier) {
		this.name = name;
		this.sleep = sleep;
		this.barrier = barrier;
	}

	@Override
	public void run() {

		try {
			System.out.println(name + ": started");
			System.out.println(name + ": doing some work for time " + sleep);
			Thread.sleep(sleep);

			// all threads need to wait for each other to to this barrier point
			System.out.println(name + ": waiting at barrier point");
			barrier.await();

			System.out.println(name + ": doing some work for time" + sleep);
			Thread.sleep(sleep);

			// all threads need to wait for each other to to this barrier point
			System.out.println(name + ": waiting at barrier point");
			barrier.await();

			System.out.println(name + ": finished");

		} catch (Exception e) {
		}

	}
}

public class CustomCyclicBarrier {
	public static void main(String[] args) {
		// here parameter indicates that minimum no of threads will wait at
		// barrier point
		CyclicBarrier barrier = new CyclicBarrier(2);

		// create three threads passing a name, sleep time, and cyclic barrier
		Thread T1 = new Thread(new MyRunnable("T1", 1000, barrier));
		Thread T2 = new Thread(new MyRunnable("T2", 1000, barrier));
		Thread T3 = new Thread(new MyRunnable("T3", 1000, barrier));

		// start all three threads
		T1.start();
		T2.start();
		T3.start();

	}
}
