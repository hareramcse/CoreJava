package com.hs.semaphore;

import java.util.concurrent.Semaphore;

class MyThread extends Thread {

	Semaphore semaphore;

	MyThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			semaphore.acquire();
			System.out.println(this.getName() + " acquired semaphore");
			try {
				System.out.println(this.getName()
						+ " going to sleep for 10 sec");
				sleep(10000);
			} catch (Exception e) {
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println(this.getName() + " released semaphore");
		}
	}
}

public class SemaphoreTest {

	public static void main(String args[]) {
		Semaphore semaphore = new Semaphore(2);
		// There are 4 threads try to acquire 2 semaphores. Two threads have to
		// wait for a semaphore to be released.
		MyThread mt1 = new MyThread(semaphore);
		mt1.setName("thread 1");
		MyThread mt2 = new MyThread(semaphore);
		mt1.setName("thread 2");
		MyThread mt3 = new MyThread(semaphore);
		mt1.setName("thread 3");
		MyThread mt4 = new MyThread(semaphore);
		mt1.setName("thread 4");
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}
}