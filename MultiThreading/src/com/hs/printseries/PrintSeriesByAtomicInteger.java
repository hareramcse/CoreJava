package com.hs.printseries;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadTasks implements Runnable {
	AtomicInteger atomicInteger;
	int threadPosition;

	public ThreadTasks(AtomicInteger atomicInteger, int threadPosition) {
		this.atomicInteger = atomicInteger;
		this.threadPosition = threadPosition;
	}

	@Override
	public void run() {
		while (atomicInteger.get() < 10) {
			if (atomicInteger.get() % 4 == this.threadPosition) {
				int value = atomicInteger.get() + 1;
				System.out.println("Printing output for Thread: " + this.threadPosition + "  " + value);
				atomicInteger.incrementAndGet();
			}
		}
	}
}

public class PrintSeriesByAtomicInteger {

	public static void main(String args[]) {
		AtomicInteger atomicInteger = new AtomicInteger(0);

		Thread t1 = new Thread(new ThreadTasks(atomicInteger, 0));
		Thread t2 = new Thread(new ThreadTasks(atomicInteger, 1));
		Thread t3 = new Thread(new ThreadTasks(atomicInteger, 2));
		Thread t4 = new Thread(new ThreadTasks(atomicInteger, 3));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}