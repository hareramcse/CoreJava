package com.hs.printseries;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
	CountDownLatch latch;

	public MyThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await(); // The thread keeps waiting till it is informed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Do the actual thing
	}
}

public class ThreadStartAtATimeByLatch {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		MyThread t1 = new MyThread(latch);
		MyThread t2 = new MyThread(latch);
		new Thread(t1).start();
		new Thread(t2).start();
		// Do whatever you want
		latch.countDown(); // This will inform all the threads to start
		// Continue to do whatever
	}
}
