package com.hs.semaphore;

import java.util.concurrent.Semaphore;

// mutex is also called as binary semaphore
public class BinarySemaphore {

	Semaphore binary = new Semaphore(1);

	private void mutualExclusion() {
		try {
			binary.acquire();

			// mutual exclusive region
			System.out.println(Thread.currentThread().getName()
					+ " inside mutual exclusive region");
			Thread.sleep(1000);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName()
					+ " outside of mutual exclusive region");
		}
	}

	public static void main(String args[]) {
		final BinarySemaphore test = new BinarySemaphore();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
	}
}