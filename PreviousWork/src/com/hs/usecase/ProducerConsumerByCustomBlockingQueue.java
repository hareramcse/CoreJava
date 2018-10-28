package com.hs.usecase;

import java.util.LinkedList;
import java.util.List;

class CustomBlockingQueue<E> {
	private List<Integer> queue = new LinkedList<Integer>();
	private int size;

	public CustomBlockingQueue(int size) {
		this.size = size;
	}

	public synchronized boolean put(Integer element)
			throws InterruptedException {
		while (queue.size() == size) {
			wait();
		}
		if (queue.size() == 0) {
			notifyAll();
		}
		boolean status = queue.add(element);
		return status;

	}

	public synchronized Integer take() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}
		if (queue.size() == size) {
			notifyAll();
		}
		return (Integer) queue.remove(0);
	}
}

class Producer implements Runnable {

	private CustomBlockingQueue<Integer> sharedQueue;

	public Producer(CustomBlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " produces " + i);
				sharedQueue.put(i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	private CustomBlockingQueue<Integer> sharedQueue;

	public Consumer(CustomBlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " consumes " + sharedQueue.take());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerByCustomBlockingQueue {
	public static void main(String args[]) {

		CustomBlockingQueue<Integer> sharedQueue = new CustomBlockingQueue<Integer>(
				10);

		Thread prodThread1 = new Thread(new Producer(sharedQueue));
		prodThread1.setName("producer thread 1");
		Thread prodThread2 = new Thread(new Producer(sharedQueue));
		prodThread2.setName("producer thread 2");
		Thread prodThread3 = new Thread(new Producer(sharedQueue));
		prodThread3.setName("producer thread 3");
		Thread prodThread4 = new Thread(new Producer(sharedQueue));
		prodThread4.setName("producer thread 4");
		Thread prodThread5 = new Thread(new Producer(sharedQueue));
		prodThread5.setName("producer thread 5");
		Thread prodThread6 = new Thread(new Producer(sharedQueue));
		prodThread6.setName("producer thread 6");
		Thread prodThread7 = new Thread(new Producer(sharedQueue));
		prodThread7.setName("producer thread 7");
		Thread prodThread8 = new Thread(new Producer(sharedQueue));
		prodThread8.setName("producer thread 8");
		Thread prodThread9 = new Thread(new Producer(sharedQueue));
		prodThread9.setName("producer thread 9");
		Thread prodThread10 = new Thread(new Producer(sharedQueue));
		prodThread10.setName("producer thread 10");

		Thread consThread1 = new Thread(new Consumer(sharedQueue));
		consThread1.setName("consumer thread 1");
		Thread consThread2 = new Thread(new Consumer(sharedQueue));
		consThread2.setName("consumer thread 2");
		Thread consThread3 = new Thread(new Consumer(sharedQueue));
		consThread3.setName("consumer thread 3");
		Thread consThread4 = new Thread(new Consumer(sharedQueue));
		consThread4.setName("consumer thread 4");
		Thread consThread5 = new Thread(new Consumer(sharedQueue));
		consThread5.setName("consumer thread 5");
		Thread consThread6 = new Thread(new Consumer(sharedQueue));
		consThread6.setName("consumer thread 6");
		Thread consThread7 = new Thread(new Consumer(sharedQueue));
		consThread7.setName("consumer thread 7");
		Thread consThread8 = new Thread(new Consumer(sharedQueue));
		consThread8.setName("consumer thread 8");
		Thread consThread9 = new Thread(new Consumer(sharedQueue));
		consThread9.setName("consumer thread 9");
		Thread consThread10 = new Thread(new Consumer(sharedQueue));
		consThread10.setName("consumer thread 10");

		prodThread1.start();
		prodThread2.start();
		prodThread3.start();
		prodThread4.start();
		prodThread5.start();
		prodThread6.start();
		prodThread7.start();
		prodThread8.start();
		prodThread9.start();
		prodThread10.start();

		consThread1.start();
		consThread2.start();
		consThread3.start();
		consThread4.start();
		consThread5.start();
		consThread6.start();
		consThread7.start();
		consThread8.start();
		consThread9.start();
		consThread10.start();

		System.out.println("done");
	}

}
