package com.hs.producerconsumer;

import java.util.LinkedList;
import java.util.List;

class Producer1 implements Runnable {
	private List<Integer> list;
	private int maxSize;

	public Producer1(List<Integer> list, int maxSize) {
		this.list = list;
		this.maxSize = maxSize;
	}

	public void run() {
		for (int i = 0; i <= maxSize; i++) {
			synchronized (list) {
				if (list.size() == maxSize) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.add(i);
				System.out.println(Thread.currentThread().getName()
						+ " produces " + i);
				list.notify();
			}
		}
	}
}

class Consumer1 implements Runnable {
	private List<Integer> list;

	public Consumer1(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		while (true) {
			synchronized (list) {
				if (list.size() == 0) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (list.size() > 0) {
					int consume = list.remove(0);
					System.out.println(Thread.currentThread().getName()
							+ " consumes " + consume);
				}
				list.notify();
			}
		}
	}
}

public class ProducerConsumerPatternByWaitNotify {

	public static void main(String args[]) {

		List<Integer> buffer = new LinkedList<Integer>();
		int maxSize = 5;

		Thread producer1 = new Thread(new Producer1(buffer, maxSize));
		producer1.setName("producer thread 1");
		Thread producer2 = new Thread(new Producer1(buffer, maxSize));
		producer2.setName("producer thread 2");
		Thread producer3 = new Thread(new Producer1(buffer, maxSize));
		producer3.setName("producer thread 3");
		Thread producer4 = new Thread(new Producer1(buffer, maxSize));
		producer4.setName("producer thread 4");
		Thread consumer1 = new Thread(new Consumer1(buffer));
		consumer1.setName("consumer thread 1");
		Thread consumer2 = new Thread(new Consumer1(buffer));
		consumer2.setName("consumer thread 2");

		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		consumer1.start();
		consumer2.start();

	}
}
