package com.hs.producerconsumer;

import java.util.LinkedList;
import java.util.List;

class ProducerByWaitNotify implements Runnable {
	private List<Integer> list;
	private int maxSize;

	public ProducerByWaitNotify(List<Integer> list, int maxSize) {
		this.list = list;
		this.maxSize = maxSize;
	}

	public void run() {
		for (int i = 0; i <= maxSize; i++) {
			synchronized (list) {
				while (list.size() == maxSize) {
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

class ConsumerByWaitNotify implements Runnable {
	private List<Integer> list;

	public ConsumerByWaitNotify(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		while (true) {
			synchronized (list) {
				while (list.size() == 0) {
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

public class ProducerConsumerByWaitNotify {

	public static void main(String args[]) {

		List<Integer> buffer = new LinkedList<Integer>();
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
		Thread producer6 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer6.setName("producer thread 6");
		Thread producer7 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer7.setName("producer thread 7");
		Thread producer8 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer8.setName("producer thread 8");
		Thread producer9 = new Thread(new ProducerByWaitNotify(buffer, maxSize));
		producer9.setName("producer thread 9");
		Thread producer10 = new Thread(
				new ProducerByWaitNotify(buffer, maxSize));
		producer10.setName("producer thread 10");

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
		Thread consumer6 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer6.setName("consumer thread 6");
		Thread consumer7 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer7.setName("consumer thread 7");
		Thread consumer8 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer8.setName("consumer thread 8");
		Thread consumer9 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer9.setName("consumer thread 9");
		Thread consumer10 = new Thread(new ConsumerByWaitNotify(buffer));
		consumer10.setName("consumer thread 10");

		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		producer5.start();
		producer6.start();
		producer7.start();
		producer8.start();
		producer9.start();
		producer10.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
		consumer5.start();
		consumer6.start();
		consumer7.start();
		consumer8.start();
		consumer9.start();
		consumer10.start();

	}
}
