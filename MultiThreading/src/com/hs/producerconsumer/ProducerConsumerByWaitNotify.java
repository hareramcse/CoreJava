package com.hs.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

class ProducerByWaitNotify implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;

	public ProducerByWaitNotify(Queue<Integer> list, int maxSize) {
		this.queue = list;
		this.maxSize = maxSize;
	}

	public void run() {
		for (int i = 0; i <= maxSize; i++) {
			synchronized (queue) {
				while (queue.size() == maxSize) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.add(i);
				System.out.println(Thread.currentThread().getName() + " produces " + i);
				queue.notify();
			}
		}
	}
}

class ConsumerByWaitNotify implements Runnable {
	private Queue<Integer> queue;

	public ConsumerByWaitNotify(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (queue.size() > 0) {
					int consume = queue.poll();
					System.out.println(Thread.currentThread().getName() + " consumes " + consume);
				}
				queue.notify();
			}
		}
	}
}

public class ProducerConsumerByWaitNotify {

	public static void main(String args[]) {

		Queue<Integer> buffer = new LinkedList<Integer>();
		int maxSize = 5;

		Thread producer1 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer1.setName("producer thread 1");
		Thread producer2 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer2.setName("producer thread 2");
		Thread producer3 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer3.setName("producer thread 3");
		Thread producer4 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer4.setName("producer thread 4");
		Thread producer5 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer5.setName("producer thread 5");

		Thread consumer1 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer1.setName("consumer thread 1");
		Thread consumer2 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer2.setName("consumer thread 2");
		Thread consumer3 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer3.setName("consumer thread 3");
		Thread consumer4 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer4.setName("consumer thread 4");
		Thread consumer5 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer5.setName("consumer thread 5");

		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		producer5.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
		consumer5.start();
	}
}
