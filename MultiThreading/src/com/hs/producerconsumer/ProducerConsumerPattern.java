package com.hs.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " produces " + i);
				sharedQueue.put(i);
			} catch (InterruptedException ex) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}
}

class Consumer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Consumer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " consumes " + sharedQueue.take());
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}
}

public class ProducerConsumerPattern {
	public static void main(String args[]) {

		// Creating shared object
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

		// Creating Producer and Consumer Thread
		Thread prodThread1 = new Thread(new Producer(sharedQueue));
		prodThread1.setName("producer thread 1");
		Thread prodThread2 = new Thread(new Producer(sharedQueue));
		prodThread2.setName("producer thread 2");
		Thread prodThread3 = new Thread(new Producer(sharedQueue));
		prodThread3.setName("producer thread 3");
		Thread prodThread4 = new Thread(new Producer(sharedQueue));
		prodThread4.setName("producer thread 4");
		Thread consThread1 = new Thread(new Consumer(sharedQueue));
		consThread1.setName("consumer thread 1");
		Thread consThread2 = new Thread(new Consumer(sharedQueue));
		consThread2.setName("consumer thread 2");

		// Starting producer and Consumer thread
		prodThread1.start();
		prodThread2.start();
		prodThread3.start();
		prodThread4.start();
		consThread1.start();
		consThread2.start();
	}
}